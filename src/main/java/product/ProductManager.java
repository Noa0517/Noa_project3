package product;

import java.util.ArrayList;
import java.util.List;


public class ProductManager {
	private List<Product> products;
	
	//コンストラクタ
	public ProductManager() {
		this.products = new ArrayList<>();
	}
	
	//productを追加するメソッド
	public void addProduct(Product product) {
		products.add(product);
	}
	
	//idを引数としてpuroductを削除するメソッド
	public void removeProduct(int id) {
		products.removeIf(product -> product.getId() == id);
	}
	
	//nameを引数としてproduct情報を取得するメソッド
	public Product getProductByName(String name) {
		for (Product product : products) {
			if(product.getName().equals(name)) {
				return product;
			}
		}
		return null; //該当する商品がない場合
	}


	public void displayProducts() {
		//System.out.println("---商品を5つ追加してすべての商品を追加する---");
		for (Product product : products) {
			System.out.println("Product: id=" + product.getId() + ", name=" + product.getName() + ", price=" + product.getPrice() + ", stock=" + product.getStock());
		}
	}
}