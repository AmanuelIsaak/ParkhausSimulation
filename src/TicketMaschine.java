import java.time.LocalDateTime;
import java.util.ArrayList;

public class TicketMaschine {
    private int nextTicketNumber = 1;
    private ArrayList<Ticket> tickets = new ArrayList<>();

    public Ticket erstelleTicket(Fahrzeug fahrzeug) {
        Ticket neuesTicket = new Ticket(nextTicketNumber, fahrzeug);
        tickets.add(neuesTicket);
        nextTicketNumber++;
        return neuesTicket;
    }
}

class Ticket {
    private int ticketNummer;
    private LocalDateTime einfahrtszeit;
    private LocalDateTime ausfahrtszeit;
    private Fahrzeug fahrzeug;
    private double preisProStunde = 2.0;

    public Ticket(int ticketNummer, Fahrzeug fahrzeug) {
        this.ticketNummer = ticketNummer;
        this.einfahrtszeit = LocalDateTime.now();
        this.fahrzeug = fahrzeug;
    }

    public double berechnePreis() {
        if (ausfahrtszeit == null) {
            return 0.0;
        }
        long dauerInMinuten = java.time.Duration.between(einfahrtszeit, ausfahrtszeit).toMinutes();
        double stunden = dauerInMinuten / 60.0;
        return stunden * preisProStunde;
    }
}