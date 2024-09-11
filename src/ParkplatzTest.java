import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ParkplatzTest {

    @org.junit.Test
    @Test
    public void einfahren_parktFahrzeugEin() {
        Parkhaus parkhaus = new Parkhaus();
        Stockwerk stockwerke = new Stockwerk();
        Fahrzeug fahrzeug = new Fahrzeug("123");

        parkhaus.einfahren(fahrzeug);

        assertTrue(parkhaus.stockwerke.getFirst().getParkplaetze().getFirst().isBelegt());
    }

    @Test
    public void findeFreieParkplatz_findetFreienPlatz() {
        Parkhaus parkhaus = new Parkhaus();
        // Setze einen Parkplatz als belegt
        parkhaus.stockwerke.getFirst().getParkplaetze().getFirst().belegen(new Fahrzeug("456"));

        Parkplatz freierPlatz = parkhaus.findeFreieParkplatz();

        // Überprüfe, ob ein freier Platz gefunden wurde und dieser nicht belegt ist
        assertNotNull(freierPlatz);
        assertFalse(freierPlatz.isBelegt());
    }
}

// Code geschrieben von Amanuel Isaak am 23.08.2024

