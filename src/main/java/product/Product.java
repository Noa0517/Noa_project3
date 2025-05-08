package product;

public class Product {
	//フィールド
	private int id;
	private String name;
	private double price;
	private int stock;
	
	//コンストラクタ
	public Product(int id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
	}
	
	//getterメソッド
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getStock() {
		return stock;
	}
	
	//setterメソッド
	public void setId(int id) {
		this.id = id;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
}
