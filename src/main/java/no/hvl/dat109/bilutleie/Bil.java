package no.hvl.dat109.bilutleie;

//Bil.java
/**
 * Represents a car available for rental.
 */
public class Bil {
	private String registreringsnummer;
	private String merke;
	private String modell;
	private String farge;
	private String gruppe;
	private boolean ledig;
	private int KM;

	/**
	 * Constructor to create a car.
	 * 
	 * @param registreringsnummer The registration number of the car.
	 * @param merke               The brand of the car.
	 * @param modell              The model of the car.
	 * @param farge               The color of the car.
	 * @param gruppe              The group of the car (e.g., A, B, C, D).
	 */
	public Bil(String registreringsnummer, String merke, String modell, String farge, String gruppe) {
		this.registreringsnummer = registreringsnummer;
		this.merke = merke;
		this.modell = modell;
		this.farge = farge;
		this.gruppe = gruppe;
		this.ledig = true;
		this.KM = 0;
	} //Kan bruke enum for gruppe

	// Getters and setters...
	
	@Override
	public String toString() {
	    return "Bil: Registreringsnummer: " + registreringsnummer 
	    		+ ", Merke: " + merke + ", Modell: " + modell + ", Farge: " + farge + ", Gruppe: " + gruppe;
	}

	public int getKM() {
		
		return this.KM;
	}
	public void setKM(int km) {
		this.KM = km;
	}
	
	public String getRegistreringsnummer() {
		return registreringsnummer;
	}

	public void setRegistreringsnummer(String registreringsnummer) {
		this.registreringsnummer = registreringsnummer;
	}

	public String getMerke() {
		return merke;
	}

	public void setMerke(String merke) {
		this.merke = merke;
	}

	public String getModell() {
		return modell;
	}

	public void setModell(String modell) {
		this.modell = modell;
	}

	public String getFarge() {
		return farge;
	}

	public void setFarge(String farge) {
		this.farge = farge;
	}

	public String getGruppe() {
		return gruppe;
	}

	public void setGruppe(String gruppe) {
		this.gruppe = gruppe;
	}

	public boolean erLedig() {
		return ledig;
	}

	public void setLedig() {
		this.ledig = true;
	}


	
}