package mastermind;

/**
 * @author aviolette
 * @since 7/22/15
 */
public class GuessResponse {
  private int numWhites, numReds, remainingSlots;

  public GuessResponse(int numWhites, int numReds, int remainingSlots) {
    this.numReds = numReds;
    this.numWhites = numWhites;
    this.remainingSlots = remainingSlots;
  }

  public int getNumWhites() {
    return numWhites;
  }

  public int getNumReds() {
    return numReds;
  }

  public int getRemainingSlots() {
    return remainingSlots;
  }

  @Override
  public String toString() {
    if (numReds == 0 && numWhites == 0) {
      return "non valid";
    }
    StringBuilder builder = new StringBuilder();
    for (int i=0; i < numReds; i++) {
      builder.append("R ");
    }
    for (int i=0; i < numWhites; i++) {
      builder.append("W ");
    }
    return builder.toString();
  }
}
