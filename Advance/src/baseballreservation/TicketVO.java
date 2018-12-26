package baseballreservation;

import java.util.Date;

public class TicketVO {
	// ф╪до(ticket)
	private int ticket_number_pk;
	private int play_number_fk1;
	private String play_region_fk1;
	private int seat_number_fk1;
	private String seat_grade_fk1;
	private int seat_price_fk1;
	private Date play_schedule_fk1;

	public TicketVO() {
		
	}
	
	public TicketVO(int ticket_number_pk, int play_number_fk1, String play_region_fk1, int seat_number_fk1,
			String seat_grade_fk1, int seat_price_fk1, Date play_schedule_fk1) {
		super();
		this.ticket_number_pk = ticket_number_pk;
		this.play_number_fk1 = play_number_fk1;
		this.play_region_fk1 = play_region_fk1;
		this.seat_number_fk1 = seat_number_fk1;
		this.seat_grade_fk1 = seat_grade_fk1;
		this.seat_price_fk1 = seat_price_fk1;
		this.play_schedule_fk1 = play_schedule_fk1;
	}

	public int getTicket_number_pk() {
		return ticket_number_pk;
	}

	public void setTicket_number_pk(int ticket_number_pk) {
		this.ticket_number_pk = ticket_number_pk;
	}

	public int getPlay_number_fk1() {
		return play_number_fk1;
	}

	public void setPlay_number_fk1(int play_number_fk1) {
		this.play_number_fk1 = play_number_fk1;
	}

	public String getPlay_region_fk1() {
		return play_region_fk1;
	}

	public void setPlay_region_fk1(String play_region_fk1) {
		this.play_region_fk1 = play_region_fk1;
	}

	public int getSeat_number_fk1() {
		return seat_number_fk1;
	}

	public void setSeat_number_fk1(int seat_number_fk1) {
		this.seat_number_fk1 = seat_number_fk1;
	}

	public String getSeat_grade_fk1() {
		return seat_grade_fk1;
	}

	public void setSeat_grade_fk1(String seat_grade_fk1) {
		this.seat_grade_fk1 = seat_grade_fk1;
	}

	public int getSeat_price_fk1() {
		return seat_price_fk1;
	}

	public void setSeat_price_fk1(int seat_price_fk1) {
		this.seat_price_fk1 = seat_price_fk1;
	}

	public Date getPlay_schedule_fk1() {
		return play_schedule_fk1;
	}

	public void setPlay_schedule_fk1(Date play_schedule_fk1) {
		this.play_schedule_fk1 = play_schedule_fk1;
	}
	
	
}
