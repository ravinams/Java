import java.util.Scanner;

public class RandomGuess3 {

	public static void main(String[] args) {

		char playAgain = 'N';
		Scanner input = new Scanner(System.in);

       do
       {

		int guessedValue = 0;
		int computerGenerated = 1 + (int) (Math.random() * 1000);
		boolean correctlyGuessed = false;		
		int guessedCount = 0;
		
		System.out.println("computerGenerated value : "+computerGenerated);
		do {
		
			do
			{
			   System.out.print("Please guess a number between 1 and 1000: ");
			   guessedValue = input.nextInt();
			}
			while(guessedValue < 1 || guessedValue > 1000) ;

			guessedCount++; 
			
			
				
					
					if (guessedValue > computerGenerated) {
						
						System.out.println("guess was too high!\n");
					}
				
					else if (guessedValue < computerGenerated) {
						
						System.out.println("guess was too low!\n");
					}
					
					else { // corrected guessed 
					
						System.out.println( "Congrats !. guess was correct in " + guessedCount + " attempts.\n"); 
						correctlyGuessed = true ;
					}

		  } while(!correctlyGuessed) ;
        
        System.out.print("Do you want to play again (Y or N ) :");
        playAgain = input.next().charAt(0);  

		}
		while(playAgain == 'y' || playAgain == 'Y');
		 System.out.println("Thanks for playing the game.");								
	}
}