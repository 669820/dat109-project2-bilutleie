package no.hvl.dat109.bilutleie;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	// opprett firma automatisk ettersom bare ett firma trengs
	static Firma firma = new Firma("Gurkemeie Bilutleie", "+47 98764837", 
			new Adresse("Guremeie gate 32", "8085", "Oslo"));

	public static void main(String[] args) {
		Adresse adresse;

		

		System.out.println(firma);

		skanner();

	}

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
					+ "3. Empty - Registrer ny bil \n" + "4. Empty - Gjoer reservasjon" + "5. Skriv ut informasjon"
					+ "0. Avslutt");

			int valg = scanner.nextInt();
			scanner.nextLine(); // For å konsumere linjeskiftet

			switch (valg) {
			case 1:
				firma.leggTilUtleiekontor(null);

				System.out.println(kontor + "\nOpprettet!");
				break;

			case 2:
				if (kontor == null) {
					System.out.println("Du må opprette et kontor foerst.");
					break;
				}

				break;
			case 3:
				if (kontor == null) {
					System.out.println("Du må opprette et kontor foerst.");
					break;
				}
				// Implementer logikken for å registrere en ny bil
				break;
			case 4:
				if (kontor == null) {
					System.out.println("Du må opprette et kontor foerst.");
					break;
				}
				// Implementer logikken for å gjøre reservasjon
				break;
			case 5:
				System.out.println(firma.getFirma() + "\n");
				System.out.println(adresse.getAdresseListe() + "\n");
				System.out.println(firma.getKontor() + "\n");
				System.out.println(kontor.getBilerTilgjengelig() + "\n");
				System.out.println(kunde.getKunder() + "\n");
				System.out.println(reservasjon.getReservasjoner());
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