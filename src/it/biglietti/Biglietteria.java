package it.biglietti;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class Biglietteria {
	
	

	public static void main(String[] args) {
		DecimalFormat formatter = new DecimalFormat("#.##");
		int km;
		String durata;
		boolean durataFlessibile;
		Scanner input = new Scanner(System.in);
		System.out.print("Inserire km:");
		km = Integer.parseInt(input.nextLine());
		System.out.print("Inserire eta: ");
		int eta = Integer.parseInt(input.nextLine());
		System.out.println("Desidera una durata flessibile del biglietto?(normale 30 giorni,flessibile 90)");
		durata = input.nextLine();
		if (durata.equals("si")) {
			durataFlessibile = true;
		}else{
			durataFlessibile = false;
		}
		
		
		Biglietto biglietto = null;
		try {
			biglietto = new Biglietto(km, eta,LocalDate.now(),durataFlessibile);
		} catch (Exception e1) {
			System.out.println("Si e' verificato un errore: " + e1.getMessage());
			
		}
		
		
		input.close();
		
		String prezzoFormattato = formatter.format(biglietto.calcolaPrezzo());
//		System.out.println(biglietto.calcolaPrezzo());
		System.out.println("$" + prezzoFormattato + " Biglietto in scadenza il: " + biglietto.calcolaDataScadenza() );
		
		
		
	}

}