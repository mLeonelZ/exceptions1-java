package Model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import Model.exceptions.DomainException;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
	}
		
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
		if(!checkOut.after(checkIn)) {				
			throw new DomainException("Error check out must be after check in!");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}


	public Date getCheckIn() {
		return checkIn;
	}
	
	public Date getCheckOut() {
		return checkOut;
	}
	
	
	// METODOS
	
	public long duration() {
		long dif = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkIn, Date checkOut) throws DomainException { // ela vai lançar a exceçao para ser tratada pelo try-catch do Program 
		
		Date now = new Date();
		if(checkIn.before(now) ||  checkOut.before(now)) {
			throw new DomainException("Reservation dates for updates must be future dates"); // exeção usada quando os argumentos passados são inválidos
		} 
		if(!checkOut.after(checkIn)) {				
			throw new DomainException("Error check out must be after check in!");
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;	
		
	}
	
	@Override
	public String toString() {
		return "room " + roomNumber + ", check In: " + sdf.format(checkIn) + ", check Out: " + sdf.format(checkOut) + ", " + duration() + " nights" ;
	}
	
	
	
}
