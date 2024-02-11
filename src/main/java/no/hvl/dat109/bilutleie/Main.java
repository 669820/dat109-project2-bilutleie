package no.hvl.dat109.bilutleie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import no.hvl.dat109.bilutleie.biler.Bil;
import no.hvl.dat109.bilutleie.biler.BilA;
import no.hvl.dat109.bilutleie.biler.BilB;
import no.hvl.dat109.bilutleie.biler.BilC;
import no.hvl.dat109.bilutleie.biler.BilD;

public class Main {
	
	static Firma firma;
	static Kontor bergenKontor;
	static Kontor larvikKontor;
	public static void main(String[] args) {
		
		initFirma();
		opprettStartKontor();
		
        Kunde kunde1 = new Kunde("Ole", "Bass", new Adresse("larviksveien 1", "3262", "Larvik"), "69696969");
        Kunde kunde2 = new Kunde("Justin", "Raxer", new Adresse("Bergensveien 1", "5000", "Bergen"), "42069420");
        List<Kunde> kunder = new ArrayList<>();
        kunder.add(kunde1);
        kunder.add(kunde2);
        
        initRegistrering(kunder);

        
	}
	
	public static void initFirma() {
		 Adresse adresse = new Adresse("Gateveien 1", "5000", "Bergen");
	     firma = new Firma("Gurkemeie Bilutleie", "+47 98765432", adresse);
	}
	
	
	public static void opprettStartKontor() {
		
		Adresse adresse1 = new Adresse("Festplassen 21", "5142", "Bergen");
		Adresse adresse2 = new Adresse("Indrehavn 19", "3262", "Larvik");

		bergenKontor = new Kontor("Bergen Kontor", "55512345", adresse1);
		larvikKontor = new Kontor("Larvik Kontor", "99888999", adresse2);
		
		firma.leggTilUtleiekontor(bergenKontor);
		firma.leggTilUtleiekontor(larvikKontor);

		
		Bil bil1 = new BilA("AB12345", "Toyota", "Yaris", "Blå");
		Bil bil2 = new BilA("CD12346", "Toyota", "Yaris", "Blå");
		Bil bil3 = new BilB("EF12347", "Lamborghini", "Aventador", "Gul");
		Bil bil4 = new BilB("GH12348", "Nissan", "Micra", "Grå");
		
		
		Bil bil5 = new BilC("IJ12349", "Audi", "A8", "Blå");		
		Bil bil6 = new BilC("KL12349", "Lexus", "EV", "Svart");
		Bil bil7 = new BilD("MN12349", "Toyota", "Yaris XL", "Hvite");
		
		bergenKontor.leggTilBil(bil1);
		bergenKontor.leggTilBil(bil2);
		bergenKontor.leggTilBil(bil3);
		bergenKontor.leggTilBil(bil4);
		
		larvikKontor.leggTilBil(bil5);
		larvikKontor.leggTilBil(bil6);
		larvikKontor.leggTilBil(bil7);
		
	}

	public void opprettReservasjon() {
		
	}
	
	public static void initRegistrering(List<Kunde> kunder) {
		List<Kontor> kontor = firma.getKontor();
		
		Scanner scanner = new Scanner(System.in);
		String innput = "";
		String kontorString = "";
		String velkommen = "Velkommen til " + firma.getNavn() + "!"
						 + "\nDu kan velge mellom " + firma.getKontor().size() + " kontor vi har hos oss: ";
		
		for(int i = 0; i < firma.getKontor().size(); i++) {
			kontorString += "\n"+ (i+1) + ":" + kontor.get(i).getNavn();
		}
		velkommen += kontorString +  "\nTast nummer for hvilket kontor du velger for å fortsette";	
			
		//for(Kunde x : kunder) {
			System.out.println(velkommen);
			int valg1 = scanner.nextInt();
			
			/*
			 * 1. kontor retur, 
			   2. dato og klokkeslett for utlei, 
			   3. antall dager, 
			   4. oppgi alle biler tilgjenlig i den perioden + pris for biler(dagspris) + totalpris, 
			   5. velg bil, 
			   6. opprett reservasjon
			*/
			
			//registrere returkontor
			System.out.println("Tast inn nummer på det kontoret du ønsker å returnere din bil til: " + kontorString);
			int valg2 = scanner.nextInt();
			
			//Registrer dato for utleie
	        System.out.println("Vennligst oppgi en dato i formatet ÅÅÅÅ-MM-DD (for eksempel 2024-12-24) for når du ønsker å leie: ");
	        String datoInput = scanner.next();
	        LocalDate dato = LocalDate.parse(datoInput);
			
	        //registrere antall dager
	        System.out.println("Hvor mange dager ønsker du å leie bilen ?");
	        int antallDager = scanner.nextInt();
	        System.out.println(antallDager);
		//}
		
		
	}
 	
}


