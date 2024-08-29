public class AusfahrtSchranke implements Schranken {

  @Override
  public void oeffnen() {
    System.out.println("Danke für Ihr Besuch und aufwiedersehen!");
  }

  @Override
  public void schliessen() {}
}
