package no.hvl.dat109.bilutleie;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
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

		initRegistrering(kunder); //Med innput validering!

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

	public static void initRegistrering(List<Kunde> kunder) {
		List<Kontor> kontor = firma.getKontor();
		Scanner scanner = new Scanner(System.in);

		String innput = "";
		String velkommen = velkommenValg(getKontorString());
		int kontorValg;
		int returkontor;
		LocalDate dato;
		
		for (Kunde kunde : kunder) {

			do {
				System.out.println(velkommen);
				kontorValg = scanner.nextInt() - 1;
			} while (validerKontorValg(kontorValg));

			scanner.nextLine();

			// registrere returkontor
			do {
			System.out.println("Tast inn nummer på det kontoret du ønsker å returnere din bil til: " + getKontorString());
			returkontor = scanner.nextInt() - 1;
			} while(validerKontorValg(returkontor));
			
			scanner.nextLine();

			// Registrer dato for utleie
			dato = lesDatoFraBruker(scanner);
	
			// registrere antall dager
			System.out.println("Hvor mange dager ønsker du å leie bilen ?");
			int antallDager = scanner.nextInt();
			System.out.println(antallDager);
			scanner.nextLine();

			// Liste ut alle tilgjengelige biler med pris
			List<Bil> ledigBiler = finnLedigBiler(dato, kontorValg);
			String bilerOgPris = lagBilerOgPrisListe(ledigBiler, antallDager);
			
			System.out.println("Velg en bil du ønsker: (Tast nummer til bilen) \n" + bilerOgPris);
			int bil = scanner.nextInt() - 1;
			scanner.nextLine();

			Reservasjon reservasjon = new Reservasjon(firma.getKontor().get(kontorValg), ledigBiler.get(bil), kunde, dato, antallDager);
			System.out.println("Takk for din bestilling " + kunde.getFornavn() + " " + kunde.getEtternavn());

			String brukerInn = lesKreditt(scanner);
			initUtleie(reservasjon, brukerInn);

			System.out.println("Gratulerer " + kunde.getFornavn() + "!\nDu kan nå ta deg en kjøretur (brom broom)\n");

		}

	}
	
	private static String lesKreditt(Scanner scanner) {
	    String brukerInn;
	    while (true) {
	        System.out.println("(simulering): For å opprette en utleie trenger vi din kortinformasjon (skriv 5 siffer): ");
	        brukerInn = scanner.nextLine();

	        // Sjekker om input er et heltall på nøyaktig 5 siffer
	        if (brukerInn.matches("\\d{5}")) {
	            break; 
	        } else {
	            System.out.println("Ugyldig input. Vennligst skriv inn nøyaktig 5 siffer.");
	        }
	    }
	    return brukerInn;
	}
	
	private static String lagBilerOgPrisListe(List<Bil> ledigBiler, int antallDager) {
	    StringBuilder bilerOgPris = new StringBuilder();
	    for (int i = 0; i < ledigBiler.size(); i++) {
	        Bil bil = ledigBiler.get(i);
	        bilerOgPris.append("\n ").append(i + 1).append(". ").append(bil.toString())
	                   .append(". Med en dagspris på: ").append(bil.hentPris())
	                   .append(". Totaltpris: ").append(antallDager * bil.hentPris());
	    }
	    return bilerOgPris.toString();
	}

	private static boolean validerDato(LocalDate dato) {
		return !dato.isBefore(LocalDate.now());
	}

	public static LocalDate lesDatoFraBruker(Scanner scanner) {
	    while (true) { // Loop til gyldig dato er oppgitt
	        System.out.println("Vennligst oppgi en dato i formatet ÅÅÅÅ-MM-DD (for eksempel 2024-12-24) for når du ønsker å leie:");
	        String datoInput = scanner.next();
	        try {
	            LocalDate dato = LocalDate.parse(datoInput);
	            if (validerDato(dato)) { // Sjekker at dato ikke er før dagens dato
	                return dato;
	            } else {
	                System.out.println("Datoen må være i dag eller i fremtiden. Prøv igjen.");
	            }
	        } catch (DateTimeParseException e) {
	            System.out.println("Ugyldig datoformat. Prøv igjen.");
	        }
	    }
	}
	
	private static boolean validerKontorValg(int kontorValg) {
		return kontorValg < 0 || kontorValg >= firma.getKontor().size();	
		}

	private static String getKontorString() {
		String kontorString = "";
		for (int i = 0; i < firma.getKontor().size(); i++) {
			kontorString += "\n" + (i + 1) + ":" + firma.getKontor().get(i).getNavn();
		}
		return kontorString;
	}

	private static String velkommenValg(String kontorString) {

		String velkommen = "Velkommen til " + firma.getNavn() + "!" + "\nDu kan velge mellom "
				+ firma.getKontor().size() + " kontor vi har hos oss: ";

		velkommen += kontorString + "\nTast nummer for hvilket kontor du velger for å fortsette";

		return velkommen;
	}

	private static void initUtleie(Reservasjon reservasjon, String brukerInn) {

		reservasjon.getUtleiekontor().opprettUtleie(reservasjon, brukerInn);

	}

	private static List<Bil> finnLedigBiler(LocalDate dato, int kontor) {
		return firma.getKontor().get(kontor).finnBilerFra(dato);

	}

}
