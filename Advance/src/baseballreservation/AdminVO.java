package baseballreservation;

public class AdminVO {
	//결제 목록
	private int idx_fk;
	private int pay_number_fk;
	private int ticket_number_fk;
	private int play_number_fk1;
	private int seat_number_fk1;
	private int seat_price_fk1;
	
	public AdminVO() {
		
	}
	
	public AdminVO(int idx_fk, int pay_number_fk, int ticket_number_fk, int play_number_fk1, int seat_number_fk1,
			int seat_price_fk1) {
		super();
		this.idx_fk = idx_fk;
		this.pay_number_fk = pay_number_fk;
		this.ticket_number_fk = ticket_number_fk;
		this.play_number_fk1 = play_number_fk1;
		this.seat_number_fk1 = seat_number_fk1;
		this.seat_price_fk1 = seat_price_fk1;
	}

	public int getIdx_fk() {
		return idx_fk;
	}

	public void setIdx_fk(int idx_fk) {
		this.idx_fk = idx_fk;
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

	public int getPlay_number_fk1() {
		return play_number_fk1;
	}

	public void setPlay_number_fk1(int play_number_fk1) {
		this.play_number_fk1 = play_number_fk1;
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