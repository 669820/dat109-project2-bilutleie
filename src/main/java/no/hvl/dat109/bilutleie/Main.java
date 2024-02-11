package no.hvl.dat109.bilutleie;

import java.time.LocalDate;

public class Main {
	// opprett firma automatisk ettersom bare ett firma trengs
	static Firma firma;
	
	public static void main(String[] args) {
		
        Adresse adresse = new Adresse("Gateveien 1", "5000", "Bergen");
        Kontor bergenKontor = new Kontor("Bergen Kontor", "55512345", adresse);
        Bil bil = new Bil("AB12345", "Toyota", "Yaris", "Blå", "A");
        bergenKontor.leggTilBil(bil);
        
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

		
//		firma =  new Firma("Gurkemeie Bilutleie", "+47 98764837", 
//				new Adresse("Guremeie gate 32", "8085", "Oslo"));
//
//		System.out.println(firma.toString());
//
//		skanner();

	}
/*
	public static void skanner() {
		Scanner scanner = new Scanner (System.in);
		Adresse adresse;
		Kontor kontor;
		Bil bil;
		Kunde kunde;
		Reservasjon reservasjon;
		
		while (true) {
			System.out.println("Velg en handling:\n" 
					+ "1. Opprett nytt kontor \n" 
					+ "2. Empty \n"
					+ "3. Empty - Registrer ny bil \n" 
					+ "4. Empty - Gjoer reservasjon \n" 
					+ "5. Skriv ut informasjon \n"
					+ "0. Avslutt");

			int valg = scanner.nextInt();
			scanner.nextLine(); // For å konsumere linjeskiftet

			switch (valg) {
			case 1:
				kontor = firma.leggTilNyttKontor();

				System.out.println(kontor.toString() + "\nOpprettet!");
				break;

			case 5:
				System.out.println(firma.getFirma() + "\n");
				System.out.println(firma.getKontor() + "\n");
				System.out.println("Ledige biler: " + kontor.getBilerTilgjengelig() + "\n");
				System.out.println(kunde.getAlleKunder() + "\n");
				System.out.println(reservasjon.getAlleReservasjoner() + "\n");
				break;
			case 0:
				System.out.println("Avslutter programmet.");
				System.exit(0);
			default:
				System.out.println("Ugyldig valg. Proev igjen.");
				break;
			}
		}
	}
*/
