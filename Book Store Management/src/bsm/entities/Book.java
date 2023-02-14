    package bsm.entities;

public class Book {
    private String id;
    private String name;
    private double price;
    private int quantity;
    private String status;
    private String publisherID;
	
    //CONSTRUCTOR
    public Book(String id, String name, double price, int quantity, String status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
    }
    
    public Book() {
        
    }
    
    //GETTER AND SETTER
    public void setPublisherID(String publisherID) {
        this.publisherID = publisherID;
    }
    
    
    public String getPublisherID() {
        return publisherID;
    }
    
    
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
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public void display() {
    
    }

    //DISPLAY
    @Override
    public String toString() {
        return "Book [id = " + id + ", name = " + name + ", price = " + price + ", quantity = " + quantity + ", status = "
                + status + "]";
    }
}
