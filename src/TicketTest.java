import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

public class TicketTest {

    @org.junit.Test
    @Test
    public void testPreisBerechnung() {
        Ticket ticket = new Ticket(123);
        TicketMaschine ticketMaschine = new TicketMaschine();
        ticketMaschine.fuegeTicketHinzu(ticket);

        ticket.beendeParkvorgang(); // Simulieren, dass der Parkvorgang beendet wurde

        double erwarteterPreis = 0.0;
        double berechneterPreis = ticket.preisBerechner();

        ticketMaschine.bezahlTicket(ticket.getTicketNummer());

        assertEquals(erwarteterPreis, berechneterPreis, 0.001);
    }

    @Test
    public void testTicketMaschine() {
        TicketMaschine ticketMaschine = new TicketMaschine();
        Ticket ticket = new Ticket(456);
        ticketMaschine.fuegeTicketHinzu(ticket);

        Ticket gefundenesTicket = ticketMaschine.findeTicket(ticket.getTicketNummer());
        assertNotNull(gefundenesTicket);

        ticketMaschine.bezahlTicket(ticket.getTicketNummer());
        assertNull(ticketMaschine.findeTicket(ticket.getTicketNummer()));
    }
}

// Code geschrieben von Amanuel Isaak am 23.08.2024