package mastermind;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author aviolette
 * @since 7/22/15
 */
public class MastermindTest {

  @Test
  public void testGuess1() {
    Color masterColors[] = new Color[4];
    masterColors[0] = Color.RED;
    masterColors[1] = Color.RED;
    masterColors[2] = Color.BLACK;
    masterColors[3] = Color.BLACK;
    Mastermind mastermind = new Mastermind(masterColors);
    Color guessColors[] = new Color[4];
    guessColors[0] = Color.GREEN;
    guessColors[1] = Color.BLACK;
    guessColors[2] = Color.PURPLE;
    guessColors[3] = Color.BLACK;
    GuessResponse response = mastermind.guess(new Guess(guessColors));
    assertEquals(1, response.getNumReds());
    assertEquals(1, response.getNumWhites());
  }

  @Test
  public void testGuess2() {
    Color masterColors[] = new Color[4];
    masterColors[0] = Color.RED;
    masterColors[1] = Color.RED;
    masterColors[2] = Color.BLACK;
    masterColors[3] = Color.BLACK;
    Mastermind mastermind = new Mastermind(masterColors);
    Color guessColors[] = new Color[4];
    guessColors[0] = Color.PURPLE;
    guessColors[1] = Color.CYAN;
    guessColors[2] = Color.PURPLE;
    guessColors[3] = Color.RED;
    GuessResponse response = mastermind.guess(new Guess(guessColors));
    assertEquals(0, response.getNumReds());
    assertEquals(1, response.getNumWhites());
  }


}
