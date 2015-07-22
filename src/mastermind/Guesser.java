package mastermind;

/**
 * @author aviolette
 * @since 7/22/15
 */
public interface Guesser {
  Guess guess(GuessResponse previousResponse);
}
