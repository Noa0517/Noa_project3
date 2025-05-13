package array;

class Product {
	private String productId;
	private String productName;
	private double price;
	private int stock;
	
	public String getProductId() {
		return productId;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public Product(String productId, String productName, double price, int stock) throws IllegalArgumentException {
		if(productName == null || productName.isEmpty()) {
			throw new IllegalArgumentException("商品名は空にできません。");
		}
		if(price < 0) {
			throw new IllegalArgumentException("価格はマイナスにできません。");
		}
		if (stock < 0) {
			throw new IllegalArgumentException("在庫数はマイナスにできません。");
		}
		
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.stock = stock;
	}
	
	@Override
	public String toString() {
	    return "Product: id=" + productId + ", name=" + productName + ", price=" + price + ", stock=" + stock + "を登録しました。";
	}

}
