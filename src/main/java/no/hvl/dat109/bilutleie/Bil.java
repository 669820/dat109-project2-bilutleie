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

	public void setLedig() {
		this.ledig = true;
		
	}
}