package entity;

public class Computer {
	private int id;
	private String model;
	private String pic;
	private String proDesc;
	private double price;
	
	
	public Computer() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getProDesc() {
		return proDesc;
	}
	public void setProDesc(String text) {
		this.proDesc = text;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
