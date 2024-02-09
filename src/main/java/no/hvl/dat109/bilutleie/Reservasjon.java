package no.hvl.dat109.bilutleie;

import java.time.LocalDate;

//Reservasjon.java
/**
 * Represents a reservation of a car.
 */
public class Reservasjon {
	private Kontor utleiekontor;
	private Bil bil;
	private Kunde kunde;
	private LocalDate leieDato;
	private int antallDager;
	private int antall;

	/**
	 * Constructor to create a reservation.
	 * 
	 * @param utleiekontor The rental office for the reservation.
	 * @param bil          The car being reserved.
	 * @param kunde        The customer making the reservation.
	 * @param leieDato     The rental date for the reservation.
	 * @param antallDager  The number of rental days for the reservation.
	 */
	public Reservasjon(Kontor utleiekontor, Bil bil, Kunde kunde, int antallDager) {
		this.utleiekontor = utleiekontor;
		this.bil = bil;
		this.kunde = kunde;
		this.leieDato = LocalDate.now();
		this.antallDager = antallDager;
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

	public void setAntallDager(int antallDager) {
		this.antallDager = antallDager;
	}
	
	
	@Override
	public String toString() {
	    return "Reservasjon: Kunde: " + kunde + 
	    		"\nBil: " + bil + 
	    		"\nLeie dato: " + leieDato + 
	    		"\nAntall dager: " + antallDager;
	}
}