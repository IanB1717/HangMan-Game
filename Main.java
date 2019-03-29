
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Game hangman = new Game();
        Scanner input = new Scanner(System.in);
        int turns = 5;


        hangman.scanWords();
        hangman.analyseWord();
        hangman.displayWord();
        System.out.println("**********************");
        System.out.println("You can get 5 incorrect guesses before you fail");
        System.out.println("Enter your guess to beign");


        while(turns > 0 && !hangman.isFinished()){
            String guess = input.next();
            switch(hangman.guessString(guess.toLowerCase())){
                case GUESSED_SUCCESS:
                    System.out.println("Correct! You still have " + turns + " turn(s) remaining!");
                    hangman.displayWord();
                    System.out.println("**********************");
                    break;
                case GUESSED_WRONG:
                    System.out.println(guess.toLowerCase() + " is not in the word! " + --turns + " turn(s) remain!");
                    hangman.displayWord();
                    System.out.println("---------------------");
                    System.out.println("You've incorrectly guessed:");
                    hangman.showFailedGuesses();
                    if (turns == 4) {
            			System.out.println("Wrong guess, try again");
            			System.out.println("   ____________");
            			System.out.println("   |    |");
            			System.out.println("   |");
            			System.out.println("   |");
            			System.out.println("   | ");
            			System.out.println("___|___");
            		}
            		if (turns == 3) {
            			System.out.println("Wrong guess, try again");
            			System.out.println("   ____________");
            			System.out.println("   |    |");
            			System.out.println("   |    ()");
            			System.out.println("   |");
            			System.out.println("   | ");
            			System.out.println("___|___");
            		}
            		if (turns == 2) {
            			System.out.println("Wrong guess, try again");
            			System.out.println("   ____________");
            			System.out.println("   |    |");
            			System.out.println("   |    ()");
            			System.out.println("   |    |");
            			System.out.println("   | ");
            			System.out.println("___|___");
            		}
            		if (turns == 1) {
            			System.out.println("Wrong guess, try again");
            			System.out.println("   ____________");
            			System.out.println("   |    |");
            			System.out.println("   |    ()");
            			System.out.println("   |   -|-");
            			System.out.println("   | ");
            			System.out.println("___|___");
            		}
            		if (turns == 0) {
            			System.out.println("   ____________");
            			System.out.println("   ____________");
            			System.out.println("   |    |");
            			System.out.println("   |    ()");
            			System.out.println("   |   -|-");
            			System.out.println("   |    //");
            			System.out.println("___|___");
            			System.out.println("You Lose! The word was " + hangman.getSelectedWord());
            		}
                    System.out.println("**********************");
                    break;
                case NOT_A_CHAR:
                    System.out.println("Illegitimate input! Please input a single letter.");
                    hangman.displayWord();
                    System.out.println("**********************");
                    break;
                case NOT_IN_WORD:
                    hangman.displayWord();
                    System.out.println("---------------------");
                    hangman.showFailedGuesses();
                    System.out.println("**********************");
                    turns--;
                    break;
                case ALREADY_GUESSED:
                    hangman.displayWord();
                    System.out.println("**********************");
                    break;
                default:
                    System.out.println("Unhandled case!");
                    break;
            }
        }
        if(turns ==0) {
            System.out.println("You're out of turns!");
            System.out.println("The word was: " + hangman.getSelectedWord());
        }else{
            System.out.println("Well done! You guessed the word with " + (turns) + " turn(s) remaining!");
        }
    }
}
