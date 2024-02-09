package no.hvl.dat109.bilutleie;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
        Skanner skanner = new Skanner();
        Adresse adresse = new Adresse(null, null, null);

        //opprett firma automatisk ettersom bare ett firma trengs
        Firma firma = new Firma("Gurkemeie Bilutleie", "+47 98764837", 
        		new Adresse("Guremeie gate 32", "8085", "Oslo"));
        
        
        
        System.out.println(firma);
        
        skanner.skanner();

    }
}