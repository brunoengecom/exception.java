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
	
	public String updateDates(Date checkin, Date checkout) {
		Date now = new Date(); // cria uma variavel com a data de agora		
		if (checkin.before(now) || checkout.before(now)) { // before == antes
			return "Erro in reservation";
		}
		if (! checkout.after(checkin)) {// after checa se a data e posterior a outra
				return "Error Date......";
		}
		this.chekin = checkin;
		this.checkout = checkout;
		return null;
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
