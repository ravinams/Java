package assg2p1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class ProblemA {

 
    
    private Object[] uniqueStationsList = null ;
    private Integer V = 0;
    private Map<String, LinkedList<String>> adj = null;

    public ProblemA(String infile) {
        try {
            processInput(infile);
        } catch (IOException e) {
            System.out.println("Exception encountered: " + e);
        }
    }

    /**
     * A helper method to process the input file.
     *
     * @param infile the file containing the input
     * @throws IOException
     */
    public void processInput(String infile) throws IOException {

        //inputData = new HashMap<String,String>();
        BufferedReader in = new BufferedReader(new FileReader(infile));        
              
        adj = new HashMap<>();
        Set<String> uniqueStations = new HashSet<String>();
        /*
		 * INSERT YOUR CODE HERE
         */
        String line = in.readLine();
        while (line != null) {
            String[] data = line.split(" ");

            String sourceStation = data[0];
            String destinationStation = data[1];
         
            line = in.readLine();
            V++;

            if (adj.containsKey(sourceStation)) {
                LinkedList<String> ll = adj.get(sourceStation);
                if (ll == null) {
                    ll = new LinkedList();
                }
                ll.add(destinationStation);
            } else {
                LinkedList<String> ll = new LinkedList();
                ll.add(destinationStation);
                adj.put(sourceStation, ll);
            }
            
            uniqueStations.add(sourceStation);
            uniqueStations.add(destinationStation);

        }
        in.close();
              
         uniqueStationsList = uniqueStations.toArray();

    }

    /**
     * Returns the number of routes between two stations for all pairs of
     * stations, as described in the assignment spec.
     *
     * @return the 2D hashmap containing the number of routes
     */
    public HashMap<String, HashMap<String, Integer>> findNumberOfRoutes() {
        /*
		 * INSERT YOUR CODE HERE
         */

        HashMap<String, HashMap<String, Integer>> routes = new HashMap<String, HashMap<String, Integer>>();

       
       // int uniqueStationsCnt = uniqueStationsList.length;

        for (int i = 0; i < uniqueStationsList.length; i++) {
            String src = uniqueStationsList[i].toString();
            HashMap<String, Integer> destinationList = new HashMap<String, Integer>();
            for (int j = 0; j < uniqueStationsList.length; j++) {
                String dest = uniqueStationsList[j].toString();
                destinationList.put(dest, findNumberOfRoutes(src, dest));
            }
            routes.put(src, destinationList);
        }

        return routes;
    }

    Integer findNumberOfRoutes(String src, String dest) {

        Integer rutes = 0;
        if (src.equals(dest)) {
            return 0;
        } else {
           
           rutes = countPaths(src,dest) ;
        }

        return rutes;
    }
    
    // A recursive method to count 
    // all paths from 'u' to 'd'. 
    int countPathsUtil(String u, String d, 
                    Map visited,  
                    int pathCount) 
    { 
          
        // Mark the current node as 
        // visited and print it 
        visited.put(u, Boolean.TRUE) ;
  
        // If current vertex is same as  
        // destination, then increment count 
        if (u.equals(d))
        { 
            pathCount++; 
        } 
              
        // Recur for all the vertices 
        // adjacent to this vertex 
        else
        { 
            LinkedList<String> ll = adj.get(u) ;
            if (ll == null)
                return pathCount ;
            Iterator<String> i = ll.listIterator(); 
            while (i.hasNext())  
            { 
                String n = i.next(); 
                if (visited.get(n).equals(Boolean.FALSE))  
                { 
                    pathCount = countPathsUtil(n, d, 
                                            visited, 
                                            pathCount); 
                } 
            } 
        } 
  
         visited.put(u, Boolean.FALSE) ;
        //visited[u] = false; 
        return pathCount; 
    } 
  
    // Returns count of 
    // paths from 's' to 'd' 
    int countPaths(String s, String d) 
    { 
          
        // Mark all the vertices 
        // as not visited 
       // boolean visited[] = new boolean[V]; 
        Map<String , Boolean> visited = new HashMap() ;
        for (int i = 0 ; i < uniqueStationsList.length ; i++)
        {
            visited.put(uniqueStationsList[i].toString(), Boolean.FALSE) ;
        }
                 
        // Call the recursive method 
        // to count all paths 
        int pathCount = 0; 
        pathCount = countPathsUtil(s, d, 
                                visited,  
                                pathCount); 
        return pathCount; 
    } 
    
}
