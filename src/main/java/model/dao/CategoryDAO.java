package model.dao;
//package model.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.CategoryBean;

public class CategoryDAO {
	private Connection connection;
	
	//コンストラクタでDB接続
	public CategoryDAO(Connection connection) {
		this.connection = connection;
	}
	
	//全カテゴリ取得メソッド
	public List<CategoryBean> getAllCategories() {
        List<CategoryBean> categoryList = new ArrayList<>();
        String sql = "SELECT category_id, category_name FROM categories";
        System.out.println("SQLクエリ: " + sql);
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql);
        		ResultSet rs = pstmt.executeQuery()){
        	
        	while (rs.next()) {
        		CategoryBean category = new CategoryBean();
        		category.setCategoryId(rs.getInt("category_id"));
        		category.setCategoryName(rs.getString("category_name"));
        		categoryList.add(category);
        	}
        } catch (SQLException e) {
        	e.printStackTrace();
        }
        return categoryList;
	}
}
