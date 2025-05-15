package product;

import java.util.ArrayList;
import java.util.List;


public class ProductManager implements Searchable {
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
	
	//Searchableメソッド実装
	@Override
	public Product getProductByName(String name) {
		for (Product product : products) {
			if(product.getName().equals(name)) {
				return product;
			}
		}
		return null;
	}
	
	@Override
	public Product search(String name) {
		for(Product product : products) {
			if(product.getName().equals(name)) {
				return product;
			}
		}
		return null;
	}
	
	//商品情報を表示
	public void displayProducts() {
		//System.out.println("---商品一覧---");
		for(Product product : products) {
			System.out.print("Product: id=" + product.getId() + ", name=" + product.getName() + ", price=" + product.getPrice() + ", stock=" + product.getStock());
			//displayProductInfo(product);
			
			System.out.println();
		}
	}
	public void displayProductInfo(Product product) {
		if(product == null) {
			System.out.println("---商品が見つかりません---");
			return;
		}
		
		//商品の記法情報を表示
		System.out.println("Product: id=" + product.getId() + ", name=" + product.getName() + ", price=" + product.getPrice() + ", stock=" + product.getStock());
		
		//割引商品の場合のみ
		if (product instanceof DiscountedProduct) {
			DiscountedProduct dp = (DiscountedProduct) product;
			//System.out.println("---商品名「" + product.getName() + "」の情報と割引率" + (dp.getDiscountRate() * 100) + "%の情報を表示する ---");
			System.out.print(", 割引率=" + ((int)(dp.getDiscountRate() * 100)) + "%, 割引後価格=" + ((int)dp.calculateDiscountedPrice()));
		}
		
		System.out.println();
	}
}
    