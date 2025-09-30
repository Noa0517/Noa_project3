package LoginLogout.model;

public class Product {
	private String name;
	  private int price;
	  private int stock;
	  private int categoryId;

	  public Product(String name, int price, int stock, int categoryId) {
	    this.name = name;
	    this.price = price;
	    this.stock = stock;
	    this.categoryId = categoryId;
	  }

	  public String getName() { return name; }
	  public int getPrice() { return price; }
	  public int getStock() { return stock; }
	  public int getCategoryId() { return categoryId; }


}
