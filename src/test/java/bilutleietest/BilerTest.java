package bilutleietest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import no.hvl.dat109.bilutleie.biler.BilA;
public class BilerTest {

	@Test
	public void testHentPris() {
		BilA bilA = new BilA("ABC123", "Toyota", "Corolla", "Red");
		assertEquals(10_000, bilA.hentPris(), 0.01);
	}
	
	@Test
	public void testErLedig() {
		BilA bilA = new BilA("ABC123", "Toyota", "Corolla", "Red");
		assertTrue(bilA.erLedig());
		bilA.setOpptatt();
		assertFalse(bilA.erLedig());
	}
	
	@Test
	public void testToString() {
		BilA bilA = new BilA("ABC123", "Toyota", "Corolla", "Red");
		assertEquals("Bil [registreringsnummer=ABC123, merke=Toyota, modell=Corolla, farge=Red, ledig=true, KM=0]", bilA.toString());
	}
	
}
