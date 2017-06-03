package entity;

import javafx.beans.property.SimpleStringProperty;

public class ReadEntity {
	
	private  SimpleStringProperty type;  
    private  SimpleStringProperty size;  
    private  SimpleStringProperty time;
	
    public ReadEntity(String type, String size, String time) {  
        this.type = new SimpleStringProperty(type);
        this.size = new SimpleStringProperty(size);
        this.time = new SimpleStringProperty(time);
    }

	public String getType() {
		return type.get();
	}

	public void setType(String type) {
		this.type.set(type);
	}

	public String getSize() {
		return size.get();
	}

	public void setSize(String size) {
		this.size.set(size);
	}

	public String getTime() {
		return time.get();
	}

	public void setTime(String time) {
		this.time.set(time);
	}  

   

    
}
