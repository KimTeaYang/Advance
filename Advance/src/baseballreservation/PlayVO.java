package baseballreservation;

import java.sql.Date;

public class PlayVO {
	// 경기일정(play)
	private int play_number_pk;
	private String play_region_pk;
	private Date play_schedule;
	private String play_home;
	private String play_away;
	
	public PlayVO() {
		
	}
	public PlayVO(int play_number_pk, String play_region_pk, Date play_schedule, String play_home, String play_away) {
		super();
		this.play_number_pk = play_number_pk;
		this.play_region_pk = play_region_pk;
		this.play_schedule = play_schedule;
		this.play_home = play_home;
		this.play_away = play_away;
	}
	
	public PlayVO(int play_number_pk, String play_region_pk, Date play_schedule) {
		super();
		this.play_number_pk = play_number_pk;
		this.play_region_pk = play_region_pk;
		this.play_schedule = play_schedule;
	}
	
	public int getPlay_number_pk() {
		return play_number_pk;
	}
	public void setPlay_number_pk(int play_number_pk) {
		this.play_number_pk = play_number_pk;
	}
	public String getPlay_region_pk() {
		return play_region_pk;
	}
	public void setPlay_region_pk(String play_region_pk) {
		this.play_region_pk = play_region_pk;
	}
	public Date getPlay_schedule() {
		return play_schedule;
	}
	public void setPlay_schedule(Date play_schedule) {
		this.play_schedule = play_schedule;
	}
	public String getPlay_home() {
		return play_home;
	}
	public void setPlay_home(String play_home) {
		this.play_home = play_home;
	}
	public String getPlay_away() {
		return play_away;
	}
	public void setPlay_away(String play_away) {
		this.play_away = play_away;
	}
	
}
