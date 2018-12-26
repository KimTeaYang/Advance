package baseballreservation;

import java.util.Date;

public class SeatVO {
	// ¿¹¸ÅÁÂ¼®(seat)
	private int play_number_fk2;
	private String play_region_fk2;
	private int seat_number_fk2;
	private String seat_ox_fk2;
	private String seat_grade_fk2;
	private int seat_price_fk2;
	private Date play_schedule_fk2;
	
	public SeatVO() {	
	}
	
	public SeatVO(int play_number_fk2, String play_region_fk2, int seat_number_fk2) {
		super();
		this.play_number_fk2 = play_number_fk2;
		this.play_region_fk2 = play_region_fk2;
		this.seat_number_fk2 = seat_number_fk2;
	}

	public SeatVO(int play_number_fk2, String play_region_fk2, int seat_number_fk2, String seat_ox_fk2, String seat_grade_fk2,
			int seat_price_fk2, Date play_schedule_fk2) {
		super();
		this.play_number_fk2 = play_number_fk2;
		this.play_region_fk2 = play_region_fk2;
		this.seat_number_fk2 = seat_number_fk2;
		this.seat_ox_fk2 = seat_ox_fk2;
		this.seat_grade_fk2 = seat_grade_fk2;
		this.seat_price_fk2 = seat_price_fk2;
		this.play_schedule_fk2 = play_schedule_fk2;
	}
	
	public String getSeat_ox_fk2() {
		return seat_ox_fk2;
	}
	public void setSeat_ox_fk2(String seat_ox_fk2) {
		this.seat_ox_fk2 = seat_ox_fk2;
	}
	public String getSeat_grade_fk2() {
		return seat_grade_fk2;
	}
	public void setSeat_grade_fk2(String seat_grade_fk2) {
		this.seat_grade_fk2 = seat_grade_fk2;
	}
	public int getSeat_price_fk2() {
		return seat_price_fk2;
	}
	public void setSeat_price_fk2(int seat_price_fk2) {
		this.seat_price_fk2 = seat_price_fk2;
	}
	public Date getPlay_schedule_fk2() {
		return play_schedule_fk2;
	}
	public void setPlay_schedule_fk2(Date play_schedule_fk2) {
		this.play_schedule_fk2 = play_schedule_fk2;
	}
	
	public int getPlay_number_fk2() {
		return play_number_fk2;
	}
	public void setPlay_number_fk2(int play_number_fk2) {
		this.play_number_fk2 = play_number_fk2;
	}
	public String getplay_region_fk2() {
		return play_region_fk2;
	}
	public void setplay_region_fk2(String play_region_fk2) {
		this.play_region_fk2 = play_region_fk2;
	}
	public int getSeat_number_fk2() {
		return seat_number_fk2;
	}
	public void setSeat_number_fk2(int seat_number_fk2) {
		this.seat_number_fk2 = seat_number_fk2;
	}
	
}
