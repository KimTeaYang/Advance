package baseballreservation;

import java.sql.Date;

public class ManagerVO {
	// 회원관리(manaer)
	private int idx_pk;
	private String name;
	private String id;
	private String pwd;
	private String email;
	private String ph;
	private String addr;
	private Date indate;
	
	public ManagerVO() {
	}

	public ManagerVO(int idx_pk, String name, String id, String pwd, String email, String ph, String addr,
			Date indate) {
		super();
		this.idx_pk = idx_pk;
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.email = email;
		this.ph = ph;
		this.addr = addr;
		this.indate = indate;
	}

	public int getIdx_pk() {
		return idx_pk;
	}

	public void setIdx_pk(int idx_pk) {
		this.idx_pk = idx_pk;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPh() {
		return ph;
	}

	public void setPh(String ph) {
		this.ph = ph;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Date getIndate() {
		return indate;
	}

	public void setIndate(Date indate) {
		this.indate = indate;
	}
	
}
