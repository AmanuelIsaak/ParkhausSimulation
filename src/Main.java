public static void main(String[] args) {
    String NummerSchild = "CH BS 69420";
    int ticketNummer = 234947;

    TicketMaschine ticketMaschine = new TicketMaschine();
    Parkhaus meinParkhaus = new Parkhaus();
    Fahrzeug meinFahrzeug = new Fahrzeug(NummerSchild);
    Ticket meinTicket = new Ticket(ticketNummer);

    Simulation meinSimulation = new Simulation(meinFahrzeug, meinParkhaus, ticketNummer, ticketMaschine);

}

// Code geschrieben von Amanuel Isaak am 23.08.2024