package no.hvl.dat109.bilutleie;

import java.util.ArrayList;
import java.util.List;

// Klassen som representerer et firma
class Firma {
	private String navn;
	private String telefon;
	private Adresse adresse;
	private List<Kontor> kontorer;

	// Konstruktør: opprett firma automatisk ettersom bare ett firma trengs
	public Firma() {
		navn = "BobsDeling";
		telefon = "+47 5555 8085";
		adresse = new Adresse("Bobs gate 32", "8085", "Oslo");
		this.kontorer = new ArrayList<>();
	}

	// Metode for å legge til et utleiekontor til firmaet
	public void leggTilUtleiekontor(Kontor kontor) {
		kontorer.add(kontor);
	}
	
    public Firma getFirma() {
        return this;
    }
	
	@Override
	public String toString() {
	    return "Firma: " + navn + ", Telefon: " + telefon + ", Adresse: " + adresse;
	}
}