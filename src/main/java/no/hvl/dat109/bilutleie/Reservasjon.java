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
	public Kontor getUtleiekontor() {
		return utleiekontor;
	}

	public void setUtleiekontor(Kontor utleiekontor) {
		this.utleiekontor = utleiekontor;
	}

	public Bil getBil() {
		return bil;
	}

	public void setBil(Bil bil) {
		this.bil = bil;
	}

	public Kunde getKunde() {
		return kunde;
	}

	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}

	public String getLeieDato() {
		return leieDato;
	}

	public void setLeieDato(String leieDato) {
		this.leieDato = leieDato;
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