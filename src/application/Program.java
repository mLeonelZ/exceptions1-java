package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Model.entities.Reservation;
import Model.exceptions.DomainException;

public class Program {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.println("Room Number: ");
			int room = sc.nextInt();
			
			System.out.println("Enter check in date: (dd/mm/yyyy)");
			Date checkIn = sdf.parse(sc.next());
			System.out.println("Enter check out date: (dd/mm/yyyy)");
			Date checkOut = sdf.parse(sc.next());
			
			
			Reservation reservation = new Reservation(room, checkIn, checkOut);
			System.out.println("Reservation : " + reservation);
			
			System.out.println("");
			System.out.println("Enter data to update the reservation: ");
			
			System.out.println("Enter check in date: (dd/mm/yyyy)");
			checkIn = sdf.parse(sc.next());
			System.out.println("Enter check out date: (dd/mm/yyyy)");
			checkOut = sdf.parse(sc.next()); 
								
			reservation.updateDates(checkIn, checkOut);
					
			System.out.println("Reservation : " + reservation);					
		}
		catch(ParseException e ) {
			System.out.println("Invalid date format");
		}
		catch(DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpeted error");
		}
		
		
		sc.close();
	}

}
