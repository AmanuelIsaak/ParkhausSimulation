import java.util.ArrayList;

class Stockwerk {
    private ArrayList<Parkplatz> parkplaetze = new ArrayList<>(5);
    private TicketMaschine ticketMaschine;
    public ArrayList<Parkplatz> getParkplaetze() {
        return parkplaetze;
    }
}
