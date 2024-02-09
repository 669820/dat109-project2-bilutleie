package no.hvl.dat109.bilutleie;

import java.util.ArrayList;
import java.util.List;

//Kontor.java
/**
 * Represents an office for the car rental company.
 */
public class Kontor {
	private String navn;
	private String telefon;
	private Adresse adresse;
	private static int kontorNummerCounter = 1;
	private int kontorNummer;
	private List<Bil> bilerTilgjengelig;

	/**
	 * Constructor to create an office.
	 * 
	 * @param navn    The name of the office.
	 * @param telefon The phone number of the office.
	 * @param adresse The address of the office.
	 */
	public Kontor(String navn, String telefon, Adresse adresse) {
		this.navn = navn;
		this.telefon = telefon;
		this.adresse = adresse;
		this.kontorNummer = kontorNummerCounter++;
		this.bilerTilgjengelig = new ArrayList<>();
	}
	
    // Metode for å legge til en bil til utleiekontoret
    public void leggTilBil(Bil bil) {
        bilerTilgjengelig.add(bil);
    }

	// Getters and setters...
    
    @Override
    public String toString() {
        return "Kontor " + kontorNummer + ": " + navn + ", Telefon: " + telefon + ", Adresse: " + adresse;
    }
}