package no.hvl.dat109.bilutleie;

import java.util.ArrayList;
import java.util.List;

// Klassen som representerer et firma
class Firma {
	private String navn;
	private String telefon;
	private Adresse adresse;
	private List<Kontor> kontor;

	/**
	 * 
	 * @param navn
	 * @param telefon
	 * @param adresse
	 */
	public Firma(String navn, String telefon, Adresse adresse) {
		this.navn = navn;
		this.telefon = telefon;
		this.adresse = adresse;
		this.kontor = new ArrayList<Kontor>();
	}

	
	public void leggTilUtleiekontor(Kontor kontorNy) {
		this.kontor.add(kontorNy);
	}
	
	
	
    public Firma getFirma() {
        return this;
    }
	
	@Override
	public String toString() {
	    return "Firma: " + navn + ", Telefon: " + telefon + ", Adresse: " + adresse;
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

	public List<Kontor> getKontor() {
		return kontor;
	}

	public void setKontor(List<Kontor> kontor) {
		this.kontor = kontor;
	}
	
	
	
	
	
}