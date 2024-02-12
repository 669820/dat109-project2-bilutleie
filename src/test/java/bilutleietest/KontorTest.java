package bilutleietest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

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

public class KontorTest {
    private Kontor kontor;
    private Bil bil;
    private Reservasjon reservasjon;
    private Utleie utleie;
    private Kunde kunde;

    @Before
    public void setUp() {
        kontor = new Kontor("Hertz", "12345678", new Adresse("Gateveien 1", "1234", "Oslo"));
        bil = new BilA("ABC123", "Toyota", "Rav4", "Blå");
        kunde = new Kunde("Ola", "Nordmann", new Adresse("Adresseveien 2", "5678", "Bergen"), "12345678");
        LocalDate leieStartDato = LocalDate.of(2024, 2, 10);
        int antallDager = 5;
        reservasjon = new Reservasjon(kontor, bil, kunde, leieStartDato, antallDager);

        utleie = new Utleie(reservasjon);
    }

    @Test
    public void testReserverBil() {
        assertTrue(kontor.reserverBil(bil));
    }

    @Test
    public void testFinnReservasjon() {
        kontor.opprettUtleie(reservasjon, "55555");
        Reservasjon funnetReservasjon = kontor.finnReservasjon(reservasjon.getID());
        assertEquals(reservasjon.getID(), funnetReservasjon.getID());
        assertEquals(reservasjon.getUtleiekontor(), funnetReservasjon.getUtleiekontor());
        assertEquals(reservasjon.getBil(), funnetReservasjon.getBil());
        assertEquals(reservasjon.getKunde(), funnetReservasjon.getKunde());
        assertEquals(reservasjon.getLeieStartDato(), funnetReservasjon.getLeieStartDato());
        assertEquals(reservasjon.getLeieSluttDato(), funnetReservasjon.getLeieSluttDato());
        assertEquals(reservasjon.getAntallDager(), funnetReservasjon.getAntallDager());
    }
}