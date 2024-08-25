abstract public class Schranken {
    private boolean offen = false;

    public void oeffnen() {
        this.offen = true;
        System.out.println("Schranken offen");
    }
    public void schliessen() {
        this.offen = false;
        System.out.println("Schranken zu");
    }
}

class AusfahrtSchranke extends Schranken {

}

class EinfahrtSchranke extends Schranken {

}