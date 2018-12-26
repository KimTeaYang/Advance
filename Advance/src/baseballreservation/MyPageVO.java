package baseballreservation;

import java.util.Date;

public class MyPageVO {
	private int pay_number_fk;
	private int ticket_number_fk;
	private Date play_schedule_fk1;
	private int seat_number_fk1;
	private int seat_price_fk1;
	
	public MyPageVO() {
		super();
	}
	
	public MyPageVO(int pay_number_fk, int ticket_number_fk, Date play_schedule_fk1, int seat_number_fk1,
			int seat_price_fk1) {
		super();
		this.pay_number_fk = pay_number_fk;
		this.ticket_number_fk = ticket_number_fk;
		this.play_schedule_fk1 = play_schedule_fk1;
		this.seat_number_fk1 = seat_number_fk1;
		this.seat_price_fk1 = seat_price_fk1;
	}

	public int getPay_number_fk() {
		return pay_number_fk;
	}

	public void setPay_number_fk(int pay_number_fk) {
		this.pay_number_fk = pay_number_fk;
	}

	public int getTicket_number_fk() {
		return ticket_number_fk;
	}

	public void setTicket_number_fk(int ticket_number_fk) {
		this.ticket_number_fk = ticket_number_fk;
	}

	public Date getPlay_schedule_fk1() {
		return play_schedule_fk1;
	}

	public void setPlay_schedule_fk1(Date play_schedule_fk1) {
		this.play_schedule_fk1 = play_schedule_fk1;
	}

	public int getSeat_number_fk1() {
		return seat_number_fk1;
	}

	public void setSeat_number_fk1(int seat_number_fk1) {
		this.seat_number_fk1 = seat_number_fk1;
	}

	public int getSeat_price_fk1() {
		return seat_price_fk1;
	}

	public void setSeat_price_fk1(int seat_price_fk1) {
		this.seat_price_fk1 = seat_price_fk1;
	}
	
}