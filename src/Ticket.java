import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Ticket {
    private final int ticketNummer;
    private final LocalDateTime einfahrt;
    private LocalDateTime ausfahrt;
    private static final double PREIS_PRO_STUNDE = 53.0;

    public Ticket(int ticketNummer) {
        this.ticketNummer = ticketNummer;
        this.einfahrt = LocalDateTime.now();
    }

    public double preisBerechner() {
        if (ausfahrt == null) {
            throw new IllegalStateException("Parkvorgang noch nicht beendet");
        }
        Duration dauer = Duration.between(einfahrt, ausfahrt);
        double stunden = dauer.toHoursPart();
        if (stunden <= 0) {
            throw new IllegalArgumentException("Dauer muss positiv sein");
        }
        return stunden * PREIS_PRO_STUNDE;
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
        if (ticket != null) {
            tickets.remove(ticket);
            System.out.println("Ticket " + ticketNummer + " bezahlt. Kosten: CHF" + ticket.preisBerechner());
        } else {
            System.out.println("Ticket nicht gefunden.");
        }
    }
}