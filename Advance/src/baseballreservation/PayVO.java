package baseballreservation;

public class PayVO {
	// ∞·¡¶(pay)
	private int pay_number_pk;
	private int idx_fk;
	private int pay_price;
	private String pay_way;
	private String pay_ox;
	
	public PayVO(){
		
	}
	
	public PayVO(int pay_number_pk, int idx_fk, int pay_price, String pay_way, String pay_ox) {
		super();
		this.pay_number_pk = pay_number_pk;
		this.idx_fk = idx_fk;
		this.pay_price = pay_price;
		this.pay_way = pay_way;
		this.pay_ox = pay_ox;
	}

	public int getPay_number_pk() {
		return pay_number_pk;
	}

	public void setPay_number_pk(int pay_number_pk) {
		this.pay_number_pk = pay_number_pk;
	}

	public int getIdx_fk() {
		return idx_fk;
	}

	public void setIdx_fk(int idx_fk) {
		this.idx_fk = idx_fk;
	}

	public int getPay_price() {
		return pay_price;
	}

	public void setPay_price(int pay_price) {
		this.pay_price = pay_price;
	}

	public String getPay_way() {
		return pay_way;
	}

	public void setPay_way(String pay_way) {
		this.pay_way = pay_way;
	}

	public String getPay_ox() {
		return pay_ox;
	}

	public void setPay_ox(String pay_ox) {
		this.pay_ox = pay_ox;
	}
	
	
}
