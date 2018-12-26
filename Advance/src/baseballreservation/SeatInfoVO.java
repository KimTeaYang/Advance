package baseballreservation;

public class SeatInfoVO {
	// ÁÂ¼®Á¤º¸(seatinfo);
	private int seat_number_pk;
	private String seat_ox;
	private String seat_grade;
	private int seat_price;
	
	public SeatInfoVO() {
	}
	public SeatInfoVO(int seat_number_pk, String seat_ox, String seat_grade, int seat_price) {
		super();
		this.seat_number_pk = seat_number_pk;
		this.seat_ox = seat_ox;
		this.seat_grade = seat_grade;
		this.seat_price = seat_price;
	}
	public int getSeat_number_pk() {
		return seat_number_pk;
	}
	public void setSeat_number_pk(int seat_number_pk) {
		this.seat_number_pk = seat_number_pk;
	}
	public String getSeat_ox() {
		return seat_ox;
	}
	public void setSeat_ox(String seat_ox) {
		this.seat_ox = seat_ox;
	}
	public String getSeat_grade() {
		return seat_grade;
	}
	public void setSeat_grade(String seat_grade) {
		this.seat_grade = seat_grade;
	}
	public int getSeat_price() {
		return seat_price;
	}
	public void setSeat_price(int seat_price) {
		this.seat_price = seat_price;
	}
	
}
