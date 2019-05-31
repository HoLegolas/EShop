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
import model.Product;
/**
 *
 * @author LAKE
 */
public class ProductDAO {
    public ArrayList<Product> getListProductsByCategory(long cateID) throws SQLException {
        Connection con = MySQLConnection.getConnection();
        String sql = "SELECT * FROM product WHERE cateID = '" + cateID + "'";
        PreparedStatement ps = con.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<Product> pl = new ArrayList<>();
        while(rs.next()) {
            Product product = new Product();
            product.setId(rs.getInt("proID"));
            product.setName(rs.getString("proName"));
            product.setImage(rs.getString("proImage"));
            product.setPrice(rs.getDouble("proPrice"));
            product.setQuantity(rs.getInt("proQuantity"));
            product.setManufacture(rs.getString("proManufacturer"));
            product.setOrigin(rs.getString("proOrigin"));
            product.setDescription(rs.getString("proDescription"));
            product.setCateID(rs.getInt("cateID"));
            pl.add(product);
        }
        return pl;
        
    }
    
    public static void main(String[] args) throws SQLException {
        ProductDAO dao = new ProductDAO();
        for (Product p : dao.getListProductsByCategory(1)) {
            System.out.println(p.getId() + " - " + p.getName());
        }
    }
}
