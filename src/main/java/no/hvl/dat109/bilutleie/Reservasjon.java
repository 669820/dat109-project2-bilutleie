package no.hvl.dat109.bilutleie;

//Reservasjon.java
/**
 * Represents a reservation of a car.
 */
public class Reservasjon {
	private Kontor utleiekontor;
	private Bil bil;
	private Kunde kunde;
	private String leieDato;
	private int antallDager;

	/**
	 * Constructor to create a reservation.
	 * 
	 * @param utleiekontor The rental office for the reservation.
	 * @param bil          The car being reserved.
	 * @param kunde        The customer making the reservation.
	 * @param leieDato     The rental date for the reservation.
	 * @param antallDager  The number of rental days for the reservation.
	 */
	public Reservasjon(Kontor utleiekontor, Bil bil, Kunde kunde, String leieDato, int antallDager) {
		this.utleiekontor = utleiekontor;
		this.bil = bil;
		this.kunde = kunde;
		this.leieDato = leieDato;
		this.antallDager = antallDager;
	}

	// Getters and setters...
	
	@Override
	public String toString() {
	    return "Reservasjon: Kunde: " + kunde + 
	    		"\nBil: " + bil + 
	    		"\nLeie dato: " + leieDato + 
	    		"\nAntall dager: " + antallDager;
	}
}