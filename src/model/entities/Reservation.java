package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exception.DomainException;

public class Reservation {
	private  Integer roomNumber;
	private Date checkin;
	private Date checkout;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkin, Date ckeckout) {
		if (! checkout.after(checkin)) {// after checa se a data e posterior a outra
			throw new DomainException("Error Date......");
	}
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = ckeckout;
	}
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Date getChekin() {
		return checkin;
	}
	
	public Date getCkeckout() {
		return checkout;
	}
	
	
	public long duration() {
		long diff = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS); // Metodo que converte a data em milisegundos
	}
	
	public void updateDates(Date checkin, Date checkout){
		Date now = new Date(); // cria uma variavel com a data de agora		
		if (checkin.before(now) || checkout.before(now)) { // before == antes
			throw new DomainException("Erro in reservation"); //Lança a excecao... retorna o erros quando os argumentos sao invalidos
		}
		if (! checkout.after(checkin)) {// after checa se a data e posterior a outra
				throw new DomainException("Error Date......");
		}
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	@Override
	public String toString() {
		return "Room"
				+ roomNumber
				+ ", check-in: "
				+ sdf.format(checkin)
				+ ", check-out: "
				+ sdf.format(checkout)
				+ ", "
				+ duration()
				+ "Nights ";
	}
	
}
