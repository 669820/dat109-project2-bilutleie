package no.hvl.dat109.bilutleie;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

//Reservasjon.java
/**
 * Represents a reservation of a car.
 */
public class Reservasjon {
	private int id;
	private Kontor utleiekontor;
	private Bil bil;
	private Kunde kunde;
	private LocalDate leieDato;
	private LocalDate levertInn;
	private int antallDager;
	private int km_kjoert;
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
	public Reservasjon(Kontor utleiekontor, Bil bil, Kunde kunde, LocalDate leieDato, int antallDager) {
		this.id = teller++;
		this.utleiekontor = utleiekontor;
		this.bil = bil;
		this.kunde = kunde;
		this.leieDato = LocalDate.now();
	}
	
	/*
	 * Regner ut antall km kjørt
	 */
	public void avsluttReservasjon(LocalDate returDato, int sluttKilometer) {
		this.levertInn = returDato;
		this.km_kjoert = sluttKilometer - bil.getKM();
		this.bil.setLedig();
		this.antallDagerLaant = (int)ChronoUnit.DAYS.between(leieDato, returDato);
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

	public LocalDate getLeieDato() {
		return leieDato;
	}

	public int getAntallDager() {
		return antallDager;
	}


	public int getID() {
		return this.id;
	}

	
	@Override
	public String toString() {
	    return "Reservasjon: Kunde: " + kunde + 
	    		"\nBil: " + bil + 
	    		"\nLeie dato: " + leieDato + 
	    		"\nAntall dager: " + antallDager;
	}



}