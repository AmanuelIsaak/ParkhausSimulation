public class Parkplatz {
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

