package no.hvl.dat109.bilutleie;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import no.hvl.dat109.bilutleie.biler.Bil;

//Reservasjon.java
/**
 * Represents a reservation of a car.
 */
public class Reservasjon {
	private int id;
	private Kontor utleiekontor;
	private Bil bil;
	private Kunde kunde;
	private LocalDate leieStartDato;
	private LocalDate leieSluttDato;
	private int antallDager;
	private int antallDagerLaant;
	
	private static int teller = 1;

	/**
	 * Constructor to create a reservation.
	 * 
	 * @param utleiekontor The rental office for the reservation.
	 * @param bil          The car being reserved.
	 * @param kunde        The customer making the reservation.
	 * @param leieDato     The rental date for the reservation.
	 * @param antallDager  The number of rental days for the reservation.
	 */
	public Reservasjon(Kontor utleiekontor, Bil bil, Kunde kunde, LocalDate leieStartDato, int antallDager) {
		this.id = teller++;
		this.utleiekontor = utleiekontor;
		this.bil = bil;
		this.kunde = kunde;
		this.leieStartDato = leieStartDato;
		this.leieSluttDato = leieStartDato.plusDays(antallDager);
	}
	
	/*
	 * Regner ut antall km kjørt
	 */
	public void avsluttReservasjon(LocalDate returDato, int sluttKilometer) {
		this.leieSluttDato = returDato;
		this.bil.setLedig();;
		this.antallDagerLaant = (int)ChronoUnit.DAYS.between(leieSluttDato, returDato);
	}
	

	// Getters and setters...
	public Kontor getUtleiekontor() {
		return utleiekontor;
	}

	public Bil getBil() {
		return bil;
	}

	public Kunde getKunde() {
		return kunde;
	}

	public LocalDate getLeieStartDato() {
		return leieStartDato;
	}
	
	public LocalDate getLeieSluttDato() {
		return leieSluttDato;
	}

	public int getAntallDager() {
		return antallDager;
	}


	public int getID() {
		return this.id;
	}

	


}