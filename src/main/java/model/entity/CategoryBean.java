package model.entity;

import java.io.Serializable;

public class CategoryBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private int category_Id;
    private String category_Name;
	
    // デフォルトコンストラクター
    public CategoryBean() {}
    
    //引数付きコンストラクター
    public CategoryBean(int category_Id, String category_Name) {
    	this.category_Id = category_Id;
    	this.category_Name = category_Name;
    }
    
    //ゲッター・セッター
    public int getCategoryId() { return category_Id; }
    public void setCategoryId(int categoryId) { this.category_Id = categoryId; }

    public String getCategoryName() { return category_Name; }
    public void setCategoryName(String categoryName) { this.category_Name = categoryName; }
    
    //デバック用のtoStringメソッド
    public String toString() {
    	return "CategoryBean{" + "categoryId=" + category_Id + ", categoryName='" + category_Name + '\'' + '}';
    }
}
