package bilutleietest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat109.bilutleie.Adresse;
import no.hvl.dat109.bilutleie.Kunde;

public class KundeTest {
    private Kunde kunde;
    private String fornavn;
    private String etternavn;
    private Adresse adresse;
    private String telefon;

    @BeforeEach
    void setUp() {
        fornavn = "Ole";
        etternavn = "Hansen";
        adresse = new Adresse("Storgata 1", "0001", "Oslo");
        telefon = "12345678";
        kunde = new Kunde(fornavn, etternavn, adresse, telefon);
    }

    @Test
    void testGetFornavn() {
        assertEquals(fornavn, kunde.getFornavn());
    }

    @Test
    void testGetEtternavn() {
        assertEquals(etternavn, kunde.getEtternavn());
    }

    @Test
    void testGetTelefon() {
        assertEquals(telefon, kunde.getTelefon());
    }

    @Test
    void testToString() {
        String expected = "Kunde: " + fornavn + " " + etternavn + ", Adresse: " + adresse + ", Telefon: " + telefon;
        assertEquals(expected, kunde.toString());
    }
    
    @Test
    void testSetFornavn() {
        String nyFornavn = "Anna";
        kunde.setFornavn(nyFornavn);
        assertEquals(nyFornavn, kunde.getFornavn());
    }

    @Test
    void testSetEtternavn() {
        String nyEtternavn = "Johansen";
        kunde.setEtternavn(nyEtternavn);
        assertEquals(nyEtternavn, kunde.getEtternavn());
    }

    @Test
    void testSetTelefon() {
        String nyTelefon = "87654321";
        kunde.setTelefon(nyTelefon);
        assertEquals(nyTelefon, kunde.getTelefon());
    }
}
