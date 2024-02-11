package no.hvl.dat109.bilutleie;

import java.time.LocalDate;

import no.hvl.dat109.bilutleie.biler.Bil;
import no.hvl.dat109.bilutleie.biler.BilA;

public class Main {
	// opprett firma automatisk ettersom bare ett firma trengs
	static Firma firma;
	
	public static void main(String[] args) {
		//test git
		
        Adresse adresse = new Adresse("Gateveien 1", "5000", "Bergen");

        Kontor bergenKontor = new Kontor("Bergen Kontor", "55512345", adresse);
        Bil bil = new BilA("AB12345", "Toyota", "Yaris", "Blå");
        bergenKontor.leggTilBil(bil);
        firma.leggTilUtleiekontor(bergenKontor);
        
        Kunde kunde = new Kunde("Ole", "Bass", adresse, "69696969");
        
        LocalDate leieStartDato = LocalDate.now().plusDays(2); 
        int leiePeriode = 5; 
        
        Reservasjon reservasjon = new Reservasjon(bergenKontor, bil, kunde, leieStartDato, leiePeriode);
        bergenKontor.leggTilReservasjon(reservasjon);
        
        Utleie utleie = new Utleie(reservasjon, bil.getKM());
        
        LocalDate forventetReturDato = leieStartDato.plusDays(leiePeriode);
        LocalDate faktiskReturDato = forventetReturDato.plusDays(3);
        int faktiskSluttKilometer = bil.getKM() + 100; 
        
        // Registrerer utleie på forventet dato
        utleie.registrerUtleie(bil.getKM());
        
        // Fast-forward til faktisk returdato (simulerer tidens gang)
        utleie.registrerRetur(faktiskSluttKilometer, faktiskReturDato);
        
        System.out.println("Regning for utleie: " + utleie.sendRegning() + " kr " + "\nSendt til " + kunde.toString());
        
	}
	
}


