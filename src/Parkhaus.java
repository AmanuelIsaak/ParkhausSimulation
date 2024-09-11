import java.util.ArrayList;

public class Parkhaus {
  ArrayList<Stockwerk> stockwerke = new ArrayList<>();
  EinfahrtSchranke einfahrtSchranke = new EinfahrtSchranke();
  AusfahrtSchranke ausfahrtSchranke = new AusfahrtSchranke();

  // hier wird instanziert, dass es 2 Stockwerke gibt
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

  public void ausfahren(Ticket ticket) {
    ausfahrtSchranke.oeffnen();
  }
}

class Stockwerk {
  private final ArrayList<Parkplatz> parkplaetze = new ArrayList<>();

  public Stockwerk() {
    int anzahlParkplätze = 5;
    for (int i = 0; i < anzahlParkplätze; i++) {
      parkplaetze.add(new Parkplatz());
    }
  }

  public ArrayList<Parkplatz> getParkplaetze() {
    return parkplaetze;
  }
}

// Code geschrieben von Amanuel Isaak am 23.08.2024
