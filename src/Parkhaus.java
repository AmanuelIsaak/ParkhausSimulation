import java.util.ArrayList;

public class Parkhaus {

    private ArrayList<Stockwerk> stockwerke = new ArrayList<>(2);
    private Schranken eingangsschranke;
    private Schranken ausgangsschranke;
    Parkplatz meinParkplatz= new Parkplatz();

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
        if (meinParkplatz == null) {
            System.out.println("Kein verfügbare Platz");
            return;
        }

        eingangsschranke.oeffnen();
        meinParkplatz.belegen(fahrzeug);
        System.out.println("Ticket lösen .....");
        Ticket neuesTicket = new Ticket(1, fahrzeug);
        TicketMaschine ticketMaschine = new TicketMaschine();
        ticketMaschine.erstelleTicket(fahrzeug);
        System.out.println("Fahrzeug " + fahrzeug.getFahrzeugID() + " fährt ein.");
        eingangsschranke.schliessen();
    }

    public double ausfahren(Ticket ticket) {
        meinParkplatz.befreiePlatz();
        ausgangsschranke.oeffnen();
        System.out.println("Fahrzeug mit Ticket " + ticket.getTicketNummer() + " fährt aus.");
        ausgangsschranke.schliessen();
        return ticket.berechnePreis();
    }
}

class Stockwerk {
    private ArrayList<Parkplatz> parkplaetze = new ArrayList<>(5);
    private TicketMaschine ticketMaschine;
    public ArrayList<Parkplatz> getParkplaetze() {
        return parkplaetze;
    }
}

class Parkplatz {
    private boolean belegt;
    private Fahrzeug fahrzeug;
    private long belegtSeit;

    public void belegen(Fahrzeug fahrzeug) {
        this.belegt = true;
        this.fahrzeug = fahrzeug;
        this.belegtSeit = System.currentTimeMillis();
    }

    public void befreiePlatz() {
        this.belegt = false;
        this.fahrzeug = null;
    }

    public boolean isBelegt() {
        return belegt;
    }
}

class Fahrzeug {
    private String FahrzeugID;

    public String getFahrzeugID() {
        return FahrzeugID;
    }
}

class Schranken {
    private boolean offen = false;

    public void oeffnen() {
        this.offen = true;
        System.out.println("Schranken offen");
    }
    public void schliessen() {
        this.offen = false;
        System.out.println("Schranken zu");
    }
}