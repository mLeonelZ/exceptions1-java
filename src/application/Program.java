package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Room Number: ");
		int room = sc.nextInt();
		
		System.out.println("Enter check in date: (dd/mm/yyyy)");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Enter check out date: (dd/mm/yyyy)");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) { // faz o teste para ver se a data de checkout está antes do checkin
			System.out.println("Error check out must be after check in!");
		} else {
			Reservation reservation = new Reservation(room, checkIn, checkOut);
			System.out.println("Reservation : " + reservation);
			
			System.out.println("");
			System.out.println("Enter data to update the reservation: ");
			
			System.out.println("Enter check in date: (dd/mm/yyyy)");
			checkIn = sdf.parse(sc.next());
			System.out.println("Enter check out date: (dd/mm/yyyy)");
			checkOut = sdf.parse(sc.next()); 
								
			String error = reservation.updateDates(checkIn, checkOut);
			
			if(error != null) {
				System.out.println("Error in reservation: " + error);
			}else {				
				System.out.println("Reservation : " + reservation);				
			}
			
			
			
			
			
		}
		
		sc.close();
	}

}
