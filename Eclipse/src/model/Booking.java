package model;

public class Booking {

	private String Date;
	private String CheckIn_Date;
	private String CheckOut_Date;
	private int Total_room;
	private int Adults;
	private int Children;
	
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	
	public String getCheckIn_Date() {
		return CheckIn_Date;
	}
	public void setCheckIn_Date(String checkIn_Date) {
		CheckIn_Date = checkIn_Date;
	}
	
	public String getCheckOut_Date() {
		return CheckOut_Date;
	}
	public void setCheckOut_Date(String checkOut_Date) {
		CheckOut_Date = checkOut_Date;
	}
	
	public int getTotal_room() {
		return Total_room;
	}
	public void setTotal_room(int total_room) {
		Total_room = total_room;
	}
	
	public int getAdults() {
		return Adults;
	}
	public void setAdults(int adults) {
		Adults = adults;
	}
	
	public int getChildren() {
		return Children;
	}
	public void setChildren(int children) {
		Children = children;
	}
}
