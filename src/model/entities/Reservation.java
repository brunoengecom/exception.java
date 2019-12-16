package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private  Integer roomNumber;
	private Date chekin;
	private Date checkout;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date chekin, Date ckeckout) {
		super();
		this.roomNumber = roomNumber;
		this.chekin = chekin;
		this.checkout = ckeckout;
	}
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Date getChekin() {
		return chekin;
	}
	
	public Date getCkeckout() {
		return checkout;
	}
	
	
	public long duration() {
		long diff = checkout.getTime() - chekin.getTime();
		return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS); // Metodo que converte a data em milisegundos
	}
	
	public void updateDates(Date checkin, Date checkout) {
		this.chekin = checkin;
		this.checkout = checkout;
	}
	
	@Override
	public String toString() {
		return "Room"
				+ roomNumber
				+ ", check-in: "
				+ sdf.format(chekin)
				+ ", check-out: "
				+ sdf.format(checkout)
				+ ", "
				+ duration()
				+ "Nights ";
	}
	
}
