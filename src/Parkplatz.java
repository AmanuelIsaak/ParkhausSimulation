public class Parkplatz {
    private enum Status { FREI, BELEGT }
    private Status status = Status.FREI;
    private Fahrzeug fahrzeug;

    public void belegen(Fahrzeug fahrzeug) {
        if (fahrzeug == null) {
            throw new IllegalArgumentException("Fahrzeug darf nicht null sein");
        }
        this.status = Status.BELEGT;
        this.fahrzeug = fahrzeug;
    }

    public void befreiePlatz() {
        this.status = Status.FREI;
        this.fahrzeug = null;
    }

    public boolean isBelegt() {
        return status == Status.BELEGT;
    }
}

class Fahrzeug {
    private String nummerSchild;
    Fahrzeug(String nummerSchild) {
        this.nummerSchild = nummerSchild;
    }
    public String getNummerSchild() {
        return nummerSchild;
    }
}
