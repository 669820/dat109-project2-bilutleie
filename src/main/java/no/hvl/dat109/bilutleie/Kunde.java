package no.hvl.dat109.bilutleie;

//Kunde.java
/**
 * Represents a customer.
 */
public class Kunde {
	private String fornavn;
	private String etternavn;
	private Adresse adresse;
	private String telefon;

	/**
	 * Constructor to create a customer.
	 * 
	 * @param fornavn   The first name of the customer.
	 * @param etternavn The last name of the customer.
	 * @param adresse   The address of the customer.
	 * @param telefon   The phone number of the customer.
	 */
	public Kunde(String fornavn, String etternavn, Adresse adresse, String telefon) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.adresse = adresse;
		this.telefon = telefon;
	}

	// Getters and setters...
	
	@Override
	public String toString() {
	    return "Kunde: " + fornavn + " " + etternavn + ", Adresse: " + adresse + ", Telefon: " + telefon;
	}
}
