package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

/*
 * 
Comentários são para fins didáticos.

*/

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Room number: ");
		Integer roomNumber = sc.nextInt();

		System.out.println("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

		/*
		 * Se a data do Check-Out for antes do Check-in, mostre a mensagem de erro,
		 * senão instancia o objeto.
		 */
		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must" + "be after check-in date");
		} else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			// Atualiza data da reserva
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.println("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			/*
			 * As datas de atualização do check-in ou Check-out, não podem ser anteriores a
			 * data agora(now), tem quer ser posterior a data da nova reserva.
			 */
			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: Reservation dates" + " for update must be future dates");

				/*
				 * Se a data do Check-Out for antes do Check-in, mostre a mensagem de erro.
				 */
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Error in reservation: Check-out date must" + "be after check-in date");

				/*
				 * Caso não ocorra nenhuma das alternativas anteriores, atualiza a nova reserva.
				 */
			} else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservation: " + reservation);
			}
		}

		sc.close();
	}

}
