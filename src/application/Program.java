package application;

import java.security.DrbgParameters.Reseed;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number");
		int number = sc.nextInt();
		
		System.out.println("Check-in date (dd/MM/yyyy)");
		Date checkin = sdf.parse(sc.next());
		
		System.out.println("Check-out date (dd/MM/yyyy)");
		Date checkout = sdf.parse(sc.next());
		
		if (! checkout.after(checkin)) {// after checa se a data e posterior a outra
			System.out.println("Error Date......");
		}else {
			Reservation reservation = new Reservation(number, checkin, checkout);
			System.out.println("Rservation" + reservation);
			
			System.out.println();
			System.out.println( "Enter date update");
			
			System.out.println("Check-in date (dd/MM/yyyy)");
			checkin = sdf.parse(sc.next());
			
			System.out.println("Check-out date (dd/MM/yyyy)");
			checkout = sdf.parse(sc.next());
			
			Date now = new Date(); // cria uma variavel com a data de agora
			
			if (checkin.before(now) || checkout.before(now)) { // before == antes
				System.out.println("Erro in reservation");
			}else {
				if (! checkout.after(checkin)) {// after checa se a data e posterior a outra
					System.out.println("Error Date......");
				}else {
					reservation.updateDates(checkin, checkout);
					System.out.println("Reservation: " + reservation);
				}
			}
			
			sc.close();
			
		}

	}

}
