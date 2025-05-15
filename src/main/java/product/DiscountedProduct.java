package product;

public class DiscountedProduct extends Product{
	private double discountRate; //割引率
	
	//コンストラクタ
	public DiscountedProduct(int id, String name, double price, int stock, double discountRate) {
		super(id, name, price, stock);
		this.discountRate = discountRate;
	}
	
	//割引後の価格を取得
	public double getDiscountedPrice() {
		return getPrice() * (1 - discountRate);
	}
	
	//割引率を取得
	public double getDiscountRate() {
		return discountRate;
	}
	
	//割引率を設定
	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}
	
	//割引価格を計算
	public double calculateDiscountedPrice() {
		return getPrice() * (1 - discountRate);
	}
}
