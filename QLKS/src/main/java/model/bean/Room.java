package model.bean;

public class Room {
	private int id;
	private String nameRoom;
	private int numBed;
	private String description;
	private double price;
	private int admin_id;
	public Room() {
	}
	public Room(int id, String nameRoom, int numBed, String description, double price, int admin_id) {
		this.id = id;
		this.nameRoom = nameRoom;
		this.numBed = numBed;
		this.description = description;
		this.price = price;
		this.admin_id = admin_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameRoom() {
		return nameRoom;
	}
	public void setNameRoom(String nameRoom) {
		this.nameRoom = nameRoom;
	}
	public int getNumBed() {
		return numBed;
	}
	public void setNumBed(int numBed) {
		this.numBed = numBed;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	
	
}
