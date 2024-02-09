package no.hvl.dat109.bilutleie;

public class Main {
	public static void main(String[] args) {
        Skanner skanner = new Skanner();

        //opprett firma automatisk ettersom bare ett firma trengs
        Firma firma = new Firma();
        
        skanner.skanner();

    }
}