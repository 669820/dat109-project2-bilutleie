package no.hvl.dat109.bilutleie;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Utleie {

	private int utleieID;
	private Reservasjon reservasjon;
	private LocalDate utleieDato;
	private int startKilometer;
	private LocalDate returDato;
	private int sluttKilometer;
	private int pris;
	
	
	//Teller for identifikator
	private static int teller = 1;
	
	/*
	 * Konstruktør
	 */
//	public Utleie(Reservasjon reservasjon, int pris) {
//		this.utleieID = teller++;
//		this.reservasjon = reservasjon;
//		this.pris = pris;
//	}
//	
//	public void registrerRetur(int utleieID) {
//		returDato = LocalDate.now();
//		//Fikse logikk for å avslutte reservasjon
//		reservasjon.avsluttReservasjon(returDato, sluttKilometer);
//	}
	
	
	public Utleie(Reservasjon reservasjon, int startKilometer) {
	    this.utleieID = teller++;
	    this.reservasjon = reservasjon;
	    this.startKilometer = startKilometer;
	    this.utleieDato = reservasjon.getLeieStartDato();
	}
	
	public void registrerUtleie(int startKilometer) {
		this.utleieDato = LocalDate.now();
		this.startKilometer = startKilometer;
		reservasjon.getBil().setKM(startKilometer);
	}
	
	
	
    public void registrerRetur(int sluttKilometer, LocalDate faktiskReturDato) {
        if(sluttKilometer < startKilometer) {
            throw new IllegalArgumentException("Slutt kilometerstand kan ikke være mindre enn start kilometerstand.");
        }
        this.sluttKilometer = sluttKilometer;
        this.returDato = faktiskReturDato;
        int kjorteKilometer = sluttKilometer - startKilometer;
        int leiedager = (int) ChronoUnit.DAYS.between(utleieDato, returDato);
        int ekstraDager = (int) ChronoUnit.DAYS.between(reservasjon.getLeieSluttDato(), returDato);

        pris = kjorteKilometer + leiedager * 100 + Math.max(ekstraDager, 0) * 150;
        reservasjon.getBil().setKM(sluttKilometer); 
        reservasjon.avsluttReservasjon(returDato, sluttKilometer);
    }

    public int sendRegning() {
        return pris;
    }
	
	
}
