package it.biglietti;

import java.math.BigDecimal;
import java.math.MathContext;

public class Biglietto {
	// gruppo 2
	

	private int km, eta;
	
	private final BigDecimal COSTO_PER_KM = new BigDecimal(0.21);
	private final BigDecimal SCONTO_OVER = new BigDecimal(0.4);
	private final BigDecimal SCONTO_UNDER = new BigDecimal(0.2);
	 
	public Biglietto(int km, int eta) {
		this.km = km;
		this.eta = eta;
	}
	
	 public boolean isValidKm() throws Exception {
		 if(km <= 0) {
			 throw new Exception("Km not valid");
		 } return true;
	 }
	 public boolean isValidEta() throws Exception {
		 if(eta <= 0) {
			 throw new Exception("Eta not valid");
		 } return true;
	 }
	 
	 private BigDecimal calcolaSconto() {
		 if (eta < 18) {
			 return SCONTO_UNDER;
		 } 
		 if (eta > 65) {
			 return SCONTO_OVER; 
		 } 
		 return new BigDecimal(0);
	 }
	 
	 public BigDecimal calcolaPrezzo() {
		 MathContext context = new MathContext(3);
		 BigDecimal kmBD = new BigDecimal(km);
		 BigDecimal costo = COSTO_PER_KM.multiply(kmBD);
		 BigDecimal sconto = costo.multiply(calcolaSconto());
		 return costo.subtract(sconto,context);
	 }

}