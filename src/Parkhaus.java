import java.util.ArrayList;
import java.util.stream.IntStream;

public class Parkhaus {
  ArrayList<Stockwerk> stockwerke = new ArrayList<>();
  EinfahrtSchranke einfahrtSchranke = new EinfahrtSchranke();
  AusfahrtSchranke ausfahrtSchranke = new AusfahrtSchranke();

  // hier wird instanziert, dass es 2 Stockwerke gibt
  public Parkhaus() {
    stockwerke.addAll(IntStream.range(0, 2)
          .mapToObj(i -> new Stockwerk())
          .toList());
  }

  Parkplatz findeFreieParkplatz() {
    return stockwerke.stream()
            .flatMap(stockwerk -> stockwerk.getParkplaetze().stream())
            .filter(parkplatz -> !parkplatz.isBelegt())
            .findFirst()
            .orElse(null);
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
      parkplaetze.addAll(IntStream.range(0, 5)
            .mapToObj(i -> new Parkplatz())
            .toList());
  }

  public ArrayList<Parkplatz> getParkplaetze() {
    return parkplaetze;
  }
}

// Code geschrieben von Amanuel Isaak am 23.08.2024
