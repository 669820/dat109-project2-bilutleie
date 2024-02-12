package bilutleietest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import no.hvl.dat109.bilutleie.Adresse;
import no.hvl.dat109.bilutleie.Kontor;
import no.hvl.dat109.bilutleie.Kunde;
import no.hvl.dat109.bilutleie.Reservasjon;
import no.hvl.dat109.bilutleie.biler.Bil;
import no.hvl.dat109.bilutleie.biler.BilA;

public class ReservasjonTest {
    
    private Reservasjon reservasjon;
    private Kontor kontor;
    private Bil bil;
    private Kunde kunde;
    private LocalDate leieStartDato;
    private int antallDager;
    
    @Before
    public void setUp() {
        kontor = new Kontor("KontorNavn", "12345678", new Adresse("Gateadresse", "1234", "Poststed"));
        bil = new BilA("ABC123", "Merke", "Modell", "Farge");
        kunde = new Kunde("Fornavn", "Etternavn", new Adresse("Gateadresse", "1234", "Poststed"), "99999999");
        leieStartDato = LocalDate.of(2024, 2, 14);
        antallDager = 5;
        reservasjon = new Reservasjon(kontor, bil, kunde, leieStartDato, 5);
    }
    
    @Test
    public void testGetReservasjon() {
        assertEquals(reservasjon, reservasjon.getReservasjon());
    }
    
    @Test
    public void testGetStatus() {
        assertTrue(reservasjon.getStatus());
    }
    
    @Test
    public void testGetUtleiekontor() {
        assertEquals(kontor, reservasjon.getUtleiekontor());
    }
    
    @Test
    public void testGetBil() {
        assertEquals(bil, reservasjon.getBil());
    }
    
    @Test
    public void testGetKunde() {
        assertEquals(kunde, reservasjon.getKunde());
    }
    
    @Test
    public void testGetLeieStartDato() {
        assertEquals(leieStartDato, reservasjon.getLeieStartDato());
    }
    
    @Test
    public void testGetLeieSluttDato() {
        assertEquals(leieStartDato.plusDays(antallDager), reservasjon.getLeieSluttDato());
    }
    
    @Test
    public void testGetAntallDager() {
    	reservasjon.setAntallDager(antallDager);
        assertEquals(antallDager, reservasjon.getAntallDager());
    }
    
    @Test
    public void testGetID() {
        assertEquals(5, reservasjon.getID());
    }
    
    @Test
    public void testGetAntallDagerLaant() {
        assertEquals(0, reservasjon.getAntallDagerLaant());
    }
}
