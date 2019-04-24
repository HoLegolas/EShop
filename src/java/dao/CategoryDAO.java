/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import connect.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Category;

/**
 *
 * @author LAKE
 */
public class CategoryDAO {
    public ArrayList<Category> getListCategory() throws SQLException {
        Connection con = MySQLConnection.getConnection();
        String sql = "SELECT * FROM category";
        PreparedStatement ps = con.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        
        ArrayList<Category> cate_list = new ArrayList<>();
        while (rs.next()) {
            Category cate = new Category();
            cate.setCategoryID(rs.getInt("cateID"));
            cate.setCategoryName(rs.getString("cateName"));
            cate_list.add(cate);
        }
        
        return cate_list;
    }
    
    public static void main(String[] args) throws SQLException {
        CategoryDAO cate_dao = new CategoryDAO();
        for (Category cate: cate_dao.getListCategory()) {
            System.out.println(cate.getCategoryID() + " - " + cate.getCategoryName());
        }
    }
}
