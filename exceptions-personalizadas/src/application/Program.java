package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainExceptions;

/*
 * 
Comentários são para fins didáticos.

*/

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.println("Room number: ");
			Integer roomNumber = sc.nextInt();
			
			System.out.println("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.println("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
			
			Reservation reservation = new Reservation(roomNumber, checkIn,
					checkOut);
			System.out.println("Reservation: " + reservation);
			
			// Atualiza data da reserva
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.println("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		
			
			
			//Trata se o formato da data inserida é inválido
		} catch(ParseException e) {
			System.out.println("Invalid date format");
			
			
			
			/*Caso as datas da atualização inseridos sejam inválidos
			 *  cai nessa exception*/
		} catch(DomainExceptions e) {
			System.out.println("Error in reservation: " + e.getMessage());
			
		}


		sc.close();
	}

}
