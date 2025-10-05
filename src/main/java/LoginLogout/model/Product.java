package LoginLogout.model;

public class Product {
	private int productId;
	private String name;
	  private int price;
	  private int stock;
	  private int categoryId;
	  
	// 登録用（IDなし）
	    public Product(String name, int price, int stock, int categoryId) {
	        this.name = name;
	        this.price = price;
	        this.stock = stock;
	        this.categoryId = categoryId;
	    }

	  public Product(int productId, String name, int price, int stock, int categoryId) {
	  //public Product(String name, int price, int stock, int categoryId) {
		this.productId = productId;
	    this.name = name;
	    this.price = price;
	    this.stock = stock;
	    this.categoryId = categoryId;
	  }
	  
	  public int getProductId() { return productId; }
	  public String getName() { return name; }
	  public int getPrice() { return price; }
	  public int getStock() { return stock; }
	  public int getCategoryId() { return categoryId; }
	  


}
