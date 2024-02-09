package no.hvl.dat109.bilutleie;

import java.util.Scanner;

public class Skanner {

	Scanner scanner = new Scanner(System.in);
	Adresse adresse = new Adresse(null, null, null);
	Firma firma = new Firma();
	Kontor kontor = new Kontor(null, null, adresse);
	Bil bil = new Bil(null, null, null, null, null); 
	Kunde kunde = new Kunde(null, null, adresse, null);
	Reservasjon reservasjon = new Reservasjon(kontor, bil, kunde, null, 0);
	

	public void skanner() {
		while (true) {
			System.out.println("Velg en handling:");
			System.out.println("1. Opprett nytt kontor");
			System.out.println("2. Empty");
			System.out.println("3. Empty - Registrer ny bil");
			System.out.println("4. Empty - Gjoer reservasjon");
			System.out.println("5. Skriv ut informasjon");
			System.out.println("0. Avslutt");

			int valg = scanner.nextInt();
			scanner.nextLine(); // For å konsumere linjeskiftet

			switch (valg) {
			case 1:
				// Implementer logikken for å legge til et nytt kontor
				System.out.println("Skriv inn navnet kontore skal ha (eksempel 'Bergen' for kontor i Bergen):");
				String navn = scanner.nextLine();
				System.out.println("Skriv inn kontorets telefonnummer:");
				String telefon = scanner.nextLine();
				System.out.println("Skriv inn kontorets gateadresse:");
				String gateadresse = scanner.nextLine();
				System.out.println("Skriv inn kontorets postnummer:");
				String postnummer = scanner.nextLine();
				System.out.println("Skriv inn kontorets poststed:");
				String poststed = scanner.nextLine();

				kontor = new Kontor(navn, telefon, new Adresse(gateadresse, postnummer, poststed));
				System.out.println(kontor + "\nOpprettet.");

				
				break;
			case 2:
				if (firma == null) {
					System.out.println("Du må opprette et kontor foerst.");
					break;
				}
				
				break;
			case 3:
				if (firma == null) {
					System.out.println("Du må opprette et kontor foerst.");
					break;
				}
				// Implementer logikken for å registrere en ny bil
				break;
			case 4:
				if (firma == null) {
					System.out.println("Du må opprette et kontor foerst.");
					break;
				}
				// Implementer logikken for å gjøre reservasjon
				break;
			case 5:
				System.out.println(firma + "\n");
            	System.out.println(adresse + "\n");
				System.out.println(kontor + "\n");
        		System.out.println(bil + "\n");
        		System.out.println(kunde + "\n");
        		System.out.println(reservasjon);
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
}
