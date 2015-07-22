package mastermind;

import java.util.Arrays;

/**
 * @author aviolette
 * @since 7/22/15
 */
public class Mastermind {
  private static final int MAX_GUESSES = 10;
  private Guess masterGuess = Guess.randomGuess();
  private int guesses = 0;
  private boolean finished = false;

  public Mastermind() {
  }

  public Mastermind(Color[] colors) {
    masterGuess = new Guess(colors);
  }

  public void reset() {
    finished = false;
    masterGuess = Guess.randomGuess();
  }

  public GuessResponse guess(Guess guess) {
    guesses++;
    if (guess.equals(masterGuess)) {
      finished = true;
      return new GuessResponse(0, masterGuess.numSpots(), MAX_GUESSES - guesses);
    }

    int numReds = 0, numWhites = 0;
    Color sourceContenders[] = guess.colors(), targetContenders[] = masterGuess.colors();

    // reds
    for (int i=0; i < sourceContenders.length; i++) {
      if (sourceContenders[i].equals(targetContenders[i])) {
        numReds++;
        sourceContenders[i] = null;
        targetContenders[i] = null;
      }
    }
    // whites
    for (Color sourceContender : sourceContenders) {
      if (sourceContender == null) {
        continue;
      }
      for (int j = 0; j < targetContenders.length; j++) {
        if (sourceContender == targetContenders[j]) {
          targetContenders[j] = null;
          numWhites++;
          break;
        }
      }
    }

    return new GuessResponse(numWhites, numReds, MAX_GUESSES - guesses);
  }

  @Override
  public String toString() {
    return masterGuess.toString();
  }

  public boolean isPlaying() {
    return !finished && guesses < MAX_GUESSES;
  }
}
