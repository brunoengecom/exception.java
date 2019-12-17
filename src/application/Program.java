package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.print("Room number");
			int number = sc.nextInt();
			
			System.out.println("Check-in date (dd/MM/yyyy)");
			Date checkin = sdf.parse(sc.next());
			
			System.out.println("Check-out date (dd/MM/yyyy)");
			Date checkout = sdf.parse(sc.next());
			
			
			Reservation reservation = new Reservation(number, checkin, checkout);
			System.out.println("Rservation" + reservation);
			
			System.out.println();
			System.out.println( "Enter date update");
			
			System.out.println("Check-in date (dd/MM/yyyy)");
			checkin = sdf.parse(sc.next());
			
			System.out.println("Check-out date (dd/MM/yyyy)");
			checkout = sdf.parse(sc.next());
				
				
			reservation.updateDates(checkin, checkout);
			System.out.println("Reservation: " + reservation);
				
			sc.close();
		}
		catch (ParseException e){
			System.out.println("Invalid date format");
		}
		catch (DomainException e) {
			System.out.println("Error in reservation" + e.getMessage()); //message e a mensagem que foi instanciada na hora de passar a excessao
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}
	}

}
