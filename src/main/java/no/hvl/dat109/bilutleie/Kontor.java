package no.hvl.dat109.bilutleie;

import java.util.ArrayList;
import java.util.List;

import no.hvl.dat109.bilutleie.biler.Bil;

//Kontor.java
/**
 * Represents an office for the car rental company.
 */
public class Kontor {
	private String navn;
	private String telefon;
	private Adresse adresse;
	private int kontorNummer;
	private List<Bil> bilerTilgjengelig;
	private List<Reservasjon> alleReservasjoner;

	//Teller for kontor ID
	private static int kontorNummerCounter = 1;
	
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
		this.alleReservasjoner = new ArrayList<>();
	}
	
   
    public void leggTilBil(Bil bil) {
        bilerTilgjengelig.add(bil);
    }

    /**
     * remove skal fjerne korrekt "bil"(bil oppgitt i parameter)
     * fra "bilerTilgjengelig" basert på 
     * java sin standard equals-metode på objekter, og ikke bare første 
     * objekt i "bilerTilgjengelig-arrayet".
     * @param bil
     */
    public void reserverBil(Bil bil) {
    	if(bil.erLedig()) {
    		bil.setOpptatt();
    		bilerTilgjengelig.remove(bil);
    	}else {
    		throw new IllegalStateException("Bilen er allerede utleid"); // MÅ kanskje fikses slik am man kan få mulighet til å velge en annen bil
    	}
    }
    
    

	public void leggTilReservasjon(Reservasjon reservasjon) {
        alleReservasjoner.add(reservasjon);
    }
	
	public Reservasjon finnReservasjon(int reservasjonID) {
		return alleReservasjoner.stream()
	            .filter(reservasjon -> reservasjon.getID() == reservasjonID)
	            .findFirst()
	            .orElse(null);
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