package no.hvl.dat109.bilutleie;

import java.util.ArrayList;
import java.util.List;

// Klassen som representerer et firma
class Firma {
	private String navn;
	private String telefon;
	private Adresse adresse;
	private List<Kontor> kontorer;

	// Konstruktør
	public Firma(String navn, String telefon, Adresse adresse) {
		this.navn = navn;
		this.telefon = telefon;
		this.adresse = adresse;
		this.kontorer = new ArrayList<>();
	}

	// Metode for å legge til et utleiekontor til firmaet
	public void leggTilUtleiekontor(Kontor kontor) {
		kontorer.add(kontor);
	}
	
	@Override
	public String toString() {
	    return "Firma: " + navn + ", Telefon: " + telefon + ", Adresse: " + adresse;
	}
}