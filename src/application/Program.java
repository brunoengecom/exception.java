package application;

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
			
			
					String error = reservation.updateDates(checkin, checkout);
					if (error != null) {
						System.out.println("Error in reservation" + error);
					}else {
						System.out.println("Reservation: " + reservation);
					}
					
				
			
			
			sc.close();
			
		}

	}

}
