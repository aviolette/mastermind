package mastermind;

/**
 * @author aviolette
 * @since 7/22/15
 */
public class NaiveGuesser implements Guesser {
  @Override
  public Guess guess(GuessResponse previousResponse) {
    return Guess.randomGuess();
  }
}
