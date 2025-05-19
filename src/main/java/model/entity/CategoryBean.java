package model.entity;

import java.io.Serializable;

public class CategoryBean implements Serializable {
    private int categoryId;
    private String categoryName;
	
    // 引数なしのコンストラクタ
    public CategoryBean() {}
    
    //引数付きコンストラクタの追加
    public CategoryBean(int categoryId, String categoryName) {
    	this.categoryId = categoryId;
    	this.categoryName = categoryName;
    }
    
    //ゲッター・セッター
    public int getCategoryId() { return categoryId; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }

    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
}
