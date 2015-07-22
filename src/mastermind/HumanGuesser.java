package mastermind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author aviolette
 * @since 7/22/15
 */
public class HumanGuesser implements Guesser {
  @Override
  public Guess guess(GuessResponse previousResponse) {
    PROMPT:
    while (true) {
      String[] colorNames = readline().split(" ");
      if (colorNames.length != 4) {
        System.err.println("Invalid number of colors");
        continue;
      }
      Color[] colors = new Color[4];
      for (int i=0; i < colorNames.length; i++) {
        colors[i] = Color.valueOf(colorNames[i]);
        if (colors[i] == null) {
          System.err.println(colorNames[i] + " is not a valid color");
          continue PROMPT;
        }
      }
      return new Guess(colors);
    }
  }

  private String readline() {
    System.out.print("\n\n> ");
    System.out.flush();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    try {
      return br.readLine();
    } catch (IOException e) {
      return "";
    }
  }

}
