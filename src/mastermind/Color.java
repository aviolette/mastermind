package mastermind;

/**
 * @author aviolette
 * @since 7/22/15
 */
public enum Color {
  WHITE,RED,ORANGE,CYAN,PURPLE,YELLOW,GREEN,BLACK;

  public static Color randomPick() {
    int random = (int)Math.ceil(Math.random() * (values().length-1));
    return values()[random];
  }
}
