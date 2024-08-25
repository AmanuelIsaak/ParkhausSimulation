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

    public void einfahren(Fahrzeug fahrzeug) {
        if (!findeFreieParkplatz().isBelegt()) {
            System.out.println("Kein verfügbare Platz");
            return;
        }
    }

    public double ausfahren(Ticket ticket) {
        return ticket.berechnePreis();
    }
}

interface Steuerung {
    public void parkieren();
    public void ausfahren();
    public void ticketBezahlen();
}