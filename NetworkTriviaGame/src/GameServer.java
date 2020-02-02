/**
 * MTServer.java
 *
 * This program implements a simple multithreaded chat server.  Every client that
 * connects to the server can broadcast data to all other clients.
 * The server stores an ArrayList of sockets to perform the broadcast.
 *
 * The MTServer uses a ClientHandler whose code is in a separate file.
 * When a client connects, the MTServer starts a ClientHandler in a separate thread 
 * to receive messages from the client.
 *
 * To test, start the server first, then start multiple clients and type messages
 * in the client windows.
 *
 */
import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class GameServer
{
	// Maintain list of all client sockets for broadcast
	private ArrayList<Socket> socketList;

	public GameServer()
	{
		socketList = new ArrayList<Socket>();
	}

	private void getConnection()
	{
		// Wait for a connection from the client
		try
		{
			System.out.println("Waiting for client connections on port 7654.");
			ServerSocket serverSock = new ServerSocket(7654);
			// This is an infinite loop, the user will have to shut it down
			// using control-c
			while (true)
			{
				Socket connectionSock = serverSock.accept();
				// Add this socket to the list
				socketList.add(connectionSock);
				
				//send array list of all current socks connected back to active client
				DataOutputStream clientOut = new DataOutputStream(connectionSock.getOutputStream());
				if (socketList.size() == 1){
					clientOut.writeBytes("No other clients are connected to the server at this time." + "\n");
				}else{
					int count = 0;
					clientOut.writeBytes("List of connected clients on " + connectionSock.getInetAddress() +":\n");
					clientOut.writeBytes("You: Port " + connectionSock.getPort() +"\n");
					for(Socket s : socketList){
						if(s != connectionSock){
							clientOut.writeBytes("Client " + (++count) + ": Port " + s.getPort() + "\n");
						}
					}
				}

				// Send to ClientHandler the socket and arraylist of all sockets
				ClientHandler handler = new ClientHandler(connectionSock, this.socketList);
				Thread theThread = new Thread(handler);
				theThread.start();
			}
			// Will never get here, but if the above loop is given
			// an exit condition then we'll go ahead and close the socket
			//serverSock.close();
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args)
	{
		GameServer server = new GameServer();
		server.getConnection();
	}
} // MTServer