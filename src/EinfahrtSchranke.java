public class EinfahrtSchranke implements Schranken {

  @Override
  public void oeffnen() {
    System.out.println("Willkommen zu unserem Parkhaus");

  }

  @Override
  public void schliessen() {
    System.out.println("Einen schönen Auftenthalt wünschen wir Ihnen noch!");

  }
}
