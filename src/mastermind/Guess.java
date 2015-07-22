package mastermind;

import java.util.Arrays;

/**
 * @author aviolette
 * @since 7/22/15
 */
public class Guess {
  private static final int COLORS = 4;
  private Color[] guessColors = new Color[COLORS];

  public Guess(Color[] colors) {
    // TODO: validate
    guessColors = colors;
  }

  public static Guess randomGuess() {
    Color[] tmp = new Color[COLORS];
    for (int i=0; i < tmp.length; i++) {
      tmp[i] = Color.randomPick();
    }
    return new Guess(tmp);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    } else if (!(obj instanceof Guess)) {
      return false;
    }
    Guess g = (Guess) obj;
    return Arrays.equals(guessColors, g.guessColors);
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(guessColors);
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    for (Color color : guessColors) {
      builder.append(color).append(" ");
    }
    return builder.toString();
  }

  public int numSpots() {
    return COLORS;
  }


  public Color[] colors() {
    return Arrays.copyOf(guessColors, guessColors.length);
  }
}
