package it.biglietti;

import java.util.Scanner;

public class Biglietteria {
	
	// gruppo 2

	public static void main(String[] args) {
		int km, eta;
		Scanner input = new Scanner(System.in);
		System.out.print("Inserire km:");
		km = input.nextInt();
		System.out.print("Inserire eta: ");
		eta = input.nextInt();
		Biglietto biglietto = new Biglietto(km, eta);
		try {
			biglietto.isValidKm();
		}catch (Exception e) {
			System.out.println("Si e' verificato un errore: " + e.getMessage());
		}
		try {
			biglietto.isValidEta();
		}catch (Exception eD) {
			System.out.println("Si e' verificato un errore: " + eD.getMessage());
		}
		
		input.close();
		
		System.out.println("$" + biglietto.calcolaPrezzo());
	}

}