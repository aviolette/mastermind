package mastermind;

/**
 * @author aviolette
 * @since 7/22/15
 */
public class Main {
  public static void main(String args[]) {
    Mastermind mastermind = new Mastermind();
//    Guesser guesser = new NaiveGuesser();
    Guesser guesser = new HumanGuesser();

    GuessResponse response = null;
    int numberofGuesses = 0;
    while (mastermind.isPlaying()) {
      numberofGuesses++;
      Guess currentGuess = guesser.guess(response);
      System.out.println("\nGuess: " + currentGuess);
      response = mastermind.guess(currentGuess);
      System.out.println("Response: " + response.toString());
    }
    System.out.println("\n\nMastermind deck");
    System.out.println(mastermind.toString());
    System.out.println("Number of moves " + numberofGuesses);
  }
}
