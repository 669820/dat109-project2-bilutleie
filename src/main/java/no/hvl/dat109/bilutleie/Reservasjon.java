package no.hvl.dat109.bilutleie;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import no.hvl.dat109.bilutleie.biler.Bil;

//Reservasjon.java
/**
 * Represents a reservation of a car.
 */
public class Reservasjon {
	private int id;
	private Kontor utleiekontor;
	private Bil bil;
	private Kunde kunde;
	private LocalDate leieStartDato;
	private LocalDate leieSluttDato;
	private int antallDager;
	private int antallDagerLaant;
	private boolean aktiv;
	
	// Teller for ID
	private static int teller = 1;


/**
 * ∫
 * @param utleiekontor
 * @param bil
 * @param kunde
 * @param leieStartDato
 * @param antallDager
 */
	public Reservasjon(Kontor utleiekontor, Bil bil, Kunde kunde, LocalDate leieStartDato, int antallDager) {
		this.id = teller++;
		this.utleiekontor = utleiekontor;
		this.bil = bil;
		this.kunde = kunde;
		this.leieStartDato = leieStartDato;
		this.leieSluttDato = leieStartDato.plusDays(antallDager);
		this.aktiv = true;
		this.antallDagerLaant = 0;
	}
	
/**
 * 
 * @param returDato
 */
	public void avsluttReservasjon(LocalDate returDato) {
		this.leieSluttDato = returDato;
		this.bil.setLedig();
		this.antallDagerLaant = (int)ChronoUnit.DAYS.between(leieStartDato, returDato);
		if(antallDagerLaant > antallDager) System.out.println("Lån av bil overskred opprinnelig avtalt dager");
		this.aktiv = false;
		utleiekontor.avsluttUtleie(this);
	}
	

	// Getters and setters...
	public Reservasjon getReservasjon() {
		return this;
	}
	
	public boolean getStatus() {
		return this.aktiv;
	}
	
	
	public Kontor getUtleiekontor() {
		return utleiekontor;
	}

	public Bil getBil() {
		return bil;
	}

	public Kunde getKunde() {
		return kunde;
	}

	public LocalDate getLeieStartDato() {
		return leieStartDato;
	}
	
	public LocalDate getLeieSluttDato() {
		return leieSluttDato;
	}

	public int getAntallDager() {
		return antallDager;
	}


	public int getID() {
		return this.id;
	}

	


}