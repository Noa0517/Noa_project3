package model.entity;

import java.io.Serializable;

public class CategoryBean implements Serializable {
	//private static final long serialVersionUID = 1L;
	
    private int category_Id;
    private String category_Name;
    
    public void setId(int category_Id) {
    	this.category_Id = category_Id;
    }
    
    public void setName(String category_Name) {
    	this.category_Name = category_Name;
    }
    
    public int getId() {
    	return category_Id;
    }
    
    public String getName() {
    	return category_Name;
    }
}
