package no.hvl.dat109.bilutleie;

//Adresse.java
/**
 * Represents an address.
 */
public class Adresse {
	private String gateadresse;
	private String postnummer;
	private String poststed;

	/**
	 * Constructor to create an address.
	 * 
	 * @param gateadresse The street address.
	 * @param postnummer  The postal code.
	 * @param poststed    The city or town name.
	 */
	public Adresse(String gateadresse, String postnummer, String poststed) {
		this.gateadresse = gateadresse;
		this.postnummer = postnummer;
		this.poststed = poststed;
	}

	// Getters and setters...
	
	@Override
	public String toString() {
	    return gateadresse + ", " + postnummer + " " + poststed;
	}
}