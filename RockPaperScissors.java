/**
 * 
 * @author  Eileen-Margaret Churchill
 * Date:    February 22, 2021
 * Purpose: To create a version of the classic "rock, paper, scissors" game in
 *          which 1,000 rounds are automated using threading.
 */
import java.util.Arrays;
import java.util.Random;
public class RockPaperScissors {

	public static void main(String[] args) {
		
		System.out.println("Ready, Player 1?\n");
		
		Player P1 = new Player("Wade Watts");
		Player P2 = new Player("IOI");
		P1.start();
		P2.start();
		}
	}


class Player extends Thread {
	
	private static final int NUMOFTHROWS = 1000;
	private static final Random RANDOM = new Random();
	private static String[] userThrows = new String[NUMOFTHROWS];
	private static String[] computerThrows = new String[NUMOFTHROWS];
	
	private Thread player;
	private String threadName;
		
	public Player(String threadName) {
		this.threadName = threadName;
		System.out.println("Creating " + threadName);
	}
				
	public void start() {
		System.out.println("Starting " + threadName);
		if (player == null) {
			player = new Thread(this, threadName);
			player.start();
		}
	}
		
	public void run() {
		System.out.println("Running " + threadName + "...");
		
		for(int i = 0; i < NUMOFTHROWS; i++) {
			if(threadName.contentEquals("Wade Watts")) {
				userThrows[i] = getGamePlay();
			}else {
				computerThrows[i] = getGamePlay();
			}
			
			try {
				Thread.sleep(50);
			}catch(InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
		
		System.out.println("\n" + threadName + " completed 1,000 rounds!");
		
		if(threadName.contentEquals("Wade Watts")) {
			System.out.println(Arrays.toString(userThrows));
		}else {
			System.out.println(Arrays.toString(computerThrows));
			System.out.print("\n");
			getPlayerScore();
		}		
	}
	
	public String getGamePlay() {
		
		if((RANDOM.nextInt(3) + 1) == 1) {
			return "Rock";
		}else if((RANDOM.nextInt(3) + 1) == 2) {
			return "Paper";
		}else {
			return "Scissors";
		}
	}
	
	public static void getPlayerScore() {
		    
		int playerScore = 0;
		int computerScore = 0;
		int tie = 0;
		
		for(int count = 0; count < NUMOFTHROWS; count++) {
			if(userThrows[count] == computerThrows[count]) {
				tie++;
			}else if(((userThrows[count] == "Rock") && (computerThrows[count] == "Scissors"))
					|| ((userThrows[count] == "Paper") && (computerThrows[count] == "Rock"))
					|| ((userThrows[count] == "Scissors") && (computerThrows[count] == "Paper"))) {
				playerScore++;
			}else {
				computerScore++;
			}
		}
		
		System.out.println("Wade Watts' Score: " + playerScore);
		System.out.println("IOI's Score: " + computerScore);
		System.out.println("Ties: " + tie);
		
		if((playerScore > computerScore) && (playerScore > tie)) {
			System.out.println("\nNice going, gunter!  You saved the OASIS!");
		}else if((computerScore > playerScore) && (computerScore > tie)) {
			System.out.println("\nOh no!  OASIS is now in the hands of the greedy"
					+ "\ncorporate mongrels at IOI.  Bummer, dude.");
		}else {
			System.out.println("\nGotta go for a rematch!");
		}
	}

/*
 *+------------------------------------------------------------------+
 *|Referenced code from the following sources:                       |
 *|   https://codereview.stackexchange.com/questions/138225/play-a-  |
 *|   game-of-rock-paper-scissors                                    | 
 *|   https://stackoverflow.com/questions/41921875/how-to-run-two-   |
 *|   thread-periodically                                            |
 *+------------------------------------------------------------------+
 */
}