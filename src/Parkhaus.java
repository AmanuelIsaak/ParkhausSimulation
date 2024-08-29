import java.util.ArrayList;

public class Parkhaus {
  private ArrayList<Stockwerk> stockwerke = new ArrayList<>();

  public Parkhaus() {
    int anzahlStockwerke = 2;
    for (int i = 0; i < anzahlStockwerke; i++) {
      stockwerke.add(new Stockwerk());
    }
  }


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
      freierPlatz.belegen(fahrzeug);
      einfahrtSchranke.schliessen();
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
  private ArrayList<Parkplatz> parkplaetze = new ArrayList<>();

  public Stockwerk() {
    int anzahlParkplätze = 5;
    for (int i = 0; i < anzahlParkplätze; i++) {
      parkplaetze.add(new Parkplatz());
    }
  }

  private TicketMaschine ticketMaschine;
  public ArrayList<Parkplatz> getParkplaetze() {
    return parkplaetze;
  }
}
