package bilutleietest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import no.hvl.dat109.bilutleie.Adresse;
import no.hvl.dat109.bilutleie.Kontor;
import no.hvl.dat109.bilutleie.Kunde;
import no.hvl.dat109.bilutleie.Reservasjon;
import no.hvl.dat109.bilutleie.Utleie;
import no.hvl.dat109.bilutleie.biler.Bil;
import no.hvl.dat109.bilutleie.biler.BilA;

public class UtleieTest {

	private Utleie utleie;
	private Bil bil;
	private Reservasjon reservasjon;
	private Kunde kunde;
	private Kontor kontor;
	private LocalDate leieStartDato;
	private int antallDager;
	
	@Before
	public void setUp() {
		bil = new BilA("ABC123", "Toyota", "Corolla", "Red"); 
		kontor = new Kontor("KontorNavn", "12345678", new Adresse("Gateadresse", "1234", "Poststed"));
        kunde = new Kunde("Fornavn", "Etternavn", new Adresse("Gateadresse", "1234", "Poststed"), "99999999");
        leieStartDato = LocalDate.of(2024, 2, 14);
        antallDager = 5;
        reservasjon = new Reservasjon(kontor, bil, kunde, leieStartDato, antallDager);
		
		utleie = new Utleie(reservasjon);
	} 
	
	//tester at Utleien ikke er null;
	@Test
	public void testRegistrerRetur() {
		Utleie utleietitten = utleie;
		assertNotNull(utleietitten);
		
	}
	
	@Test
	public void testGetID() {
		assertEquals(reservasjon.getID(), utleie.getID());
	}
	
}
