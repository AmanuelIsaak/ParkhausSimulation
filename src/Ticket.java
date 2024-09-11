import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Ticket {
    private final int ticketNummer;
    private final LocalDateTime einfahrt;
    private LocalDateTime ausfahrt;
    private static final double PREIS_PRO_MINUTE= .005;

    public Ticket(int ticketNummer) {
        this.ticketNummer = ticketNummer;
        this.einfahrt = LocalDateTime.now();
    }

    public double preisBerechner() {
        ausfahrt = LocalDateTime.now();
        Duration dauer = Duration.between(einfahrt, ausfahrt);
        double stunden = dauer.toSeconds() * 60.00; // von Sekunden zu Studen mit mal 3600 kovertiert
        System.out.println(stunden);
        return stunden * PREIS_PRO_MINUTE;
    }


    public int getTicketNummer() {
        return ticketNummer;
    }

    public void beendeParkvorgang() {
        this.ausfahrt = LocalDateTime.now();
    }
}

class TicketMaschine{
    private final List<Ticket> tickets = new ArrayList<>();

    public void fuegeTicketHinzu(Ticket ticket) {
        tickets.add(ticket);
    }

    public Ticket findeTicket(int ticketNummer) {
        return tickets.stream()
                .filter(ticket -> ticket.getTicketNummer() == ticketNummer)
                .findFirst()
                .orElse(null);
    }

    public void bezahlTicket(int ticketNummer) {
        Ticket ticket = findeTicket(ticketNummer);
        System.out.println(ticket != null ? STR."Ticket \{ticketNummer} bezahlt. Kosten: CHF \{ticket.preisBerechner()}" : "Ticket nicht gefunden.");
    }
}

// Code geschrieben von Amanuel Isaak am 23.08.2024