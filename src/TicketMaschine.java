import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;


public class TicketMaschine {
  private int autoIncrementID= 1;
  private ArrayList<Ticket> tickets = new ArrayList<>();

  public Ticket erstelleTicket(Fahrzeug fahrzeug) {
    Ticket neuesTicket = new Ticket(autoIncrementID, fahrzeug);
    tickets.add(neuesTicket);
    autoIncrementID++;
    System.out.println("Hier ist Ihr Ticket: "+neuesTicket.getTicketNummer());
    return neuesTicket;
  }
}

