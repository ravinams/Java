//Module 1  Mad Lib's game

import javax.swing.JOptionPane;

public class MadLib {

	public static void main(String[] args) {
		// will track whether player wants to play again
		boolean playAgain = false;
		
		do {
			// prompts user to enter words
			String noun1 = JOptionPane.showInputDialog(null, "Enter an noun:");
			String noun2 = JOptionPane.showInputDialog(null, "Enter another noun:");
			String adjuctive = JOptionPane.showInputDialog(null, "Enter a adjuctive:");
			String verb = JOptionPane.showInputDialog(null, "Enter a past-tense verb:");			
			// outputs Mad Libs w/ user words filled in the blanks
			JOptionPane.showMessageDialog(null, "May had a little " + noun1 + " it's " + noun2 + " was "+adjuctive+" as snow "+"And everywhere that Mary "+verb+" The table was sure to go.");
			// asks user if they want to play again
			int choice = JOptionPane.showConfirmDialog(null, "Do you want to play again?");
			// yes to play again
			if (choice == JOptionPane.YES_OPTION) {
				// sets playAgain to true to keep while loop going
				playAgain = true;
			} 
			// no or cancel to stop playing
			else if (choice == JOptionPane.NO_OPTION || choice == JOptionPane.CANCEL_OPTION) {
				// sets playAgain to false to stop while loop
				playAgain = false;
			}
		} while (playAgain); // if playAgain is true, keep playing!

	}

}
