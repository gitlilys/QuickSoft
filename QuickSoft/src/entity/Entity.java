package entity;

public class Entity {
	private String id;
	private String type;
	private int size;
	private double time;
	
	
	
	public Entity() {
		super();
	}
	
	public Entity(String id, String type, int size, double time) {
		super();
		this.id = id;
		this.type = type;
		this.size = size;
		this.time = time;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public double getTime() {
		return time;
	}
	public void setTime(double time) {
		this.time = time;
	}
	
	
	
}
