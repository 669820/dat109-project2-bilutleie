package no.hvl.dat109.bilutleie;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        Firma firma = null;
        Kontor kontor = null;
        
        while (true) {
            System.out.println("Velg en handling:");
            System.out.println("1. Opprett nytt firma");
            System.out.println("2. Legg til nytt kontor");
            System.out.println("3. Registrer ny bil");
            System.out.println("4. Gjoer reservasjon");
            System.out.println("5. Skriv ut informasjon");
            System.out.println("6. Avslutt");

            int valg = scanner.nextInt();
            scanner.nextLine(); // For å konsumere linjeskiftet

            switch (valg) {
                case 1:
                    System.out.println("Skriv inn firmaets navn:");
                    String navn = scanner.nextLine();
                    System.out.println("Skriv inn firmaets telefonnummer:");
                    String telefon = scanner.nextLine();
                    System.out.println("Skriv inn firmaets gateadresse:");
                    String gateadresse = scanner.nextLine();
                    System.out.println("Skriv inn firmaets postnummer:");
                    String postnummer = scanner.nextLine();
                    System.out.println("Skriv inn firmaets poststed:");
                    String poststed = scanner.nextLine();

                    firma = new Firma(navn, telefon, new Adresse(gateadresse, postnummer, poststed));
                    break;
                case 2:
                    if (firma == null) {
                        System.out.println("Du må opprette et firma foerst.");
                        break;
                    }
                    // Implementer logikken for å legge til et nytt kontor
                    System.out.println("Skriv inn navnet kontore skal ha (eksempel 'Bergen' for kontor i Bergen):");
                    navn = scanner.nextLine();
                    System.out.println("Skriv inn kontorets telefonnummer:");
                    telefon = scanner.nextLine();
                    System.out.println("Skriv inn kontorets gateadresse:");
                    gateadresse = scanner.nextLine();
                    System.out.println("Skriv inn kontorets postnummer:");
                    postnummer = scanner.nextLine();
                    System.out.println("Skriv inn kontorets poststed:");
                    poststed = scanner.nextLine();
                    
                    kontor = new Kontor(navn, telefon, new Adresse(gateadresse, postnummer, poststed));
                    System.out.println(kontor + "\nOpprettet.");
                    break;
                case 3:
                    if (firma == null) {
                        System.out.println("Du må opprette et firma foerst.");
                        break;
                    }
                    // Implementer logikken for å registrere en ny bil
                    break;
                case 4:
                    if (firma == null) {
                        System.out.println("Du må opprette et firma foerst.");
                        break;
                    }
                    // Implementer logikken for å gjøre reservasjon
                    break;
                case 5:
                	System.out.println(firma + "\n");
//                	System.out.println(adresse + "\n");
//            		System.out.println(kontor + "\n");
//            		System.out.println(bil + "\n");
//            		System.out.println(kunde + "\n");
//            		System.out.println(reservasjon);
                    break;
                case 6:
                    System.out.println("Avslutter programmet.");
                    System.exit(0);
                default:
                    System.out.println("Ugyldig valg. Proev igjen.");
                    break;
            }
        }
    }
}