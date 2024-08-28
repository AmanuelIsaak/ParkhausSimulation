import java.util.ArrayList;

public class Parkhaus {
  private ArrayList<Stockwerk> stockwerke = new ArrayList<>(2);


  Parkplatz findeFreieParkplatz() {
    for (Stockwerk stockwerk: stockwerke) {
      for (Parkplatz parkplatz: stockwerk.getParkplaetze()) {
        if(!parkplatz.isBelegt()) {
          return parkplatz;
        }
      }
    }
    return null;
  }

  EinfahrtSchranke einfahrtSchranke = new EinfahrtSchranke();
  AusfahrtSchranke ausfahrtSchranke = new AusfahrtSchranke();

  public void einfahren(Fahrzeug fahrzeug) {
    einfahrtSchranke.oeffnen();
    Parkplatz freierPlatz = findeFreieParkplatz();
    if (freierPlatz != null) {
      einfahrtSchranke.schliessen();
      freierPlatz.belegen(fahrzeug);
    } else {
      System.out.println("Kein verfügbarer Platz");
    }
  }

  public double ausfahren(Ticket ticket) {
    ausfahrtSchranke.oeffnen();
    return ticket.preisBerechner();
  }
}

class Stockwerk {
  private ArrayList<Parkplatz> parkplaetze = new ArrayList<>(5);
  private TicketMaschine ticketMaschine;
  public ArrayList<Parkplatz> getParkplaetze() {
    return parkplaetze;
  }
}
