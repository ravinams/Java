public class FiveDice {	
	
	public static void main(String[] args) {
		
	
		
		Die[] compDie = new Die[5]; // generates 5 die for computer
		int[] compDieScores = new int[5] ;
		// throws die for computer 5 times
		for (int i=0; i<5; i++) {			
			compDie[i] = new Die();			
			compDieScores[i] = compDie[i].getDieValue(); 	
		}
		
		Die[] playerDie = new Die[5]; 
		int[] playerDieScores = new int[5] ;
		
		// throws die for player 5 times
		for (int i=0; i<5; i++) {
			playerDie[i] = new Die();
			playerDieScores[i] = playerDie[i].getDieValue(); // saves die value			
		}		
		
			
		System.out.print("Computer dice values: ");
		for (int i=0; i < 5; i++) {
			System.out.print(compDieScores[i] + " ");
		}
		System.out.println(); 
		System.out.print("Player dice values: ");
		for (int i=0; i < 5; i++) {
			System.out.print(playerDieScores[i]+ " ");
		}
		System.out.println(); 

	}

}