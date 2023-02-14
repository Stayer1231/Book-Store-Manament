package bsm.entities;

import java.util.ArrayList;

public class Publisher {
    private String id;
    private String name;
    private String phone;
    private ArrayList<Object> listOfPublisher = new ArrayList<>();
    Publisher publisher;
	
    //CONSTRUCTOR
    public Publisher(String id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }
    
    public Publisher() {
    }
    
    //GETTER AND SETTER
    public String getId() {

        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public void display() {
    }
    
    public ArrayList<Object> getListOfPublisher() {
        return listOfPublisher;
    }
    
    @Override
    public String toString() {
        return "[ID = " + id + ", Name = " + name + ", Phone = " + phone + "]";
    }
} 
