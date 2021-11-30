package it.biglietti;

import java.math.BigDecimal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Biglietto {
	// gruppo 2
	

	private int km, eta;
	private LocalDate dataOdierna ;
	private DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private boolean durataFlessibile;
	
	
	private final BigDecimal COSTO_PER_KM = new BigDecimal(0.21);
	private final BigDecimal SCONTO_OVER = new BigDecimal(0.4);
	private final BigDecimal SCONTO_UNDER = new BigDecimal(0.2);
	private final BigDecimal MAGGIORAZIONE_PREZZO = new BigDecimal(1.1);
	private final int DURATA_NORMALE = 30;
	private final int DURATA_FLESSIBILE = 90;
	
	 
	public Biglietto(int km, int eta,LocalDate data,boolean durataFlessibile) throws Exception {
		this.km = km;
		this.eta = eta;
		this.dataOdierna = data;
		this.durataFlessibile = durataFlessibile;
		isValidKm();
		isValidEta();
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
	 
		 
		 BigDecimal kmBD = new BigDecimal(km);
		 BigDecimal costo = COSTO_PER_KM.multiply(kmBD);
		 BigDecimal sconto = costo.multiply(calcolaSconto());
		 BigDecimal costoScontato = costo.subtract(sconto);
		 if (durataFlessibile) {
			 return costoScontato.multiply(MAGGIORAZIONE_PREZZO);
		 }else {
			 return costoScontato;
		 }
	 }
	 
	 public  String calcolaDataScadenza() {
		 if (!durataFlessibile) {
			 LocalDate dataScadenza = dataOdierna.plusDays(DURATA_NORMALE);
			 return dataScadenza.format(dataFormatter);
		 }else {
			 LocalDate dataScadenza = dataOdierna.plusDays(DURATA_FLESSIBILE);
			 return dataScadenza.format(dataFormatter);
		 }
		 
		 
	 }

}