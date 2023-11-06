package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
	
	public Reservation() {
		
	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		
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

	public Date getcheckIn() {
		return checkIn;
	}

	//É apagado esse set para não mudar a data arbitrariamente
//	public void setcheckIn(Date checkIn) {
//		this.checkIn = checkIn;
//	}

	public Date getcheckOut() {
		return checkOut;
	}

	//É apagado esse set para não mudar a data arbitrariamente
//	public void setcheckOut(Date checkOut) {
//		this.checkOut = checkOut;
//	}
	
	/*
	 * É usado o Inteiro do tipo "long" para caber um número mais longo no
	 * cálculo da diferença das duas datas: entrada e saída.
	 */
	public long duration() {
		// O cálculo da diferença de datas é feito em milisegundos.
		long diff = checkOut.getTime() - checkIn.getTime();
		//Conversão de milisegundos para dias.
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public String updateDates(Date checkIn, Date checkOut) {
		
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			return "Error in reservation: Reservation dates" + " for update must be future dates";

			/*
			 * Se a data do Check-Out for antes do Check-in, mostre a mensagem de erro.
			 */
		} if (!checkOut.after(checkIn)) {
			return "Error in reservation: Check-out date must" + "be after check-in date";

			/*
			 * Caso não ocorra nenhuma das alternativas anteriores, atualiza a nova reserva.
			 */
		}
		
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
		
		//Caso retorne null, é que o programa não teve nem erro anterior
		return null;
	}

	/*
	 * Formato de impressão toString: Room 8021, check-in: 24/09/2019, 
	 * check-out: 29/09/2019, 5 nights 
	 */
	@Override
	public String toString() {
		return "Room "
				+ roomNumber
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ ", "
				+ duration()
				+ " nights";
		
	}
}
