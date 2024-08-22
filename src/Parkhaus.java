import java.util.ArrayList;

public class Parkhaus {
    private ArrayList<Stockwerk> stockwerke = new ArrayList<>(2);
    private Schranken eingangsschranke;
    private Schranken ausgangsschranke;

    public void einfahren(Fahrzeug fahrzeug) {
        Parkplatz freieParkplatz = new Parkplatz();
        if (freieParkplatz == null) {
            System.out.println("Kein verfügbare Platz");
            return;
        }

        eingangsschranke.oeffnen();
        freieParkplatz.belegen(fahrzeug);
        Ticket neuesTicket = new Ticket(1, fahrzeug);
        TicketMaschine ticketMaschine = new TicketMaschine();
        ticketMaschine.erstelleTicket(fahrzeug);
        System.out.println("Hier ist Ihr Ticket"+ neuesTicket);
        eingangsschranke.schliessen();
    }
    public double ausfahren(Ticket ticket) {
        return ticket.berechnePreis();
    }
}

class Stockwerk {
    private ArrayList<Parkplatz> parkplaetze = new ArrayList<>(50);
    private TicketMaschine ticketMaschine;
}

class Schranken {
    public void oeffnen() {
        System.out.println("Willkommen!");
    }
    public void schliessen() {
        System.out.println("Danke für Ihr Besuch, Aufwiedersehen");
    }
}

class Parkplatz {
    private int nummer;
    private boolean belegt;
    private Fahrzeug fahrzeug;
    public void belegen(Fahrzeug fahrzeug) {
        this.fahrzeug= fahrzeug;
    }
}

class Fahrzeug {
    private String FahrzeugID;
}