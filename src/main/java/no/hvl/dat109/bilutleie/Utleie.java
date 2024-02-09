package no.hvl.dat109.bilutleie;

import java.time.LocalDate;

public class Utleie {

	private int utleieID;
	private Reservasjon reservasjon;
	private int startKilometer;
	private int sluttKilometer;
	private LocalDate returDato;
	private int pris;
	
	//Teller for identifikator
	private static int teller = 1;
	
	/*
	 * Konstruktør
	 */
	public Utleie(Reservasjon reservasjon, int startKilometer, int pris) {
		this.utleieID = teller++;
		this.reservasjon = reservasjon;
		this.startKilometer = startKilometer;
		this.pris = pris;
	}
	
	public void registrerRetur(int utleieID) {
		returDato = LocalDate.now();
		//Fikse logikk for å avslutte reservasjon
	}
	
	 
	
}
