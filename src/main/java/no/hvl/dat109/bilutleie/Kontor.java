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

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public static int getKontorNummerCounter() {
		return kontorNummerCounter;
	}

	public static void setKontorNummerCounter(int kontorNummerCounter) {
		Kontor.kontorNummerCounter = kontorNummerCounter;
	}

	public int getKontorNummer() {
		return kontorNummer;
	}

	public void setKontorNummer(int kontorNummer) {
		this.kontorNummer = kontorNummer;
	}

	public List<Bil> getBilerTilgjengelig() {
		return bilerTilgjengelig;
	}

	public void setBilerTilgjengelig(List<Bil> bilerTilgjengelig) {
		this.bilerTilgjengelig = bilerTilgjengelig;
	}
    
    
}