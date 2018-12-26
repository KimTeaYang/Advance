package baseballreservation;

public class PayInfoVO {
	// 결제정보(payinfo)
	private int pay_number_fk;
	private int ticket_number_fk;
	
	public PayInfoVO() {
		
	}
	
	public PayInfoVO(int pay_number_fk, int ticket_number_fk) {
		super();
		this.pay_number_fk = pay_number_fk;
		this.ticket_number_fk = ticket_number_fk;
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
	

}
