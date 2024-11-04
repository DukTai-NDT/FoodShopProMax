/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Product;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DAOProduct extends DBConnection {

    public int insertProduct(Product other) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Products]([ProductName],[SupplierID],[CategoryID],[MfgDate],[ExpDate],[Quantity],[UnitPrice],[ImgURL],[Description])\n"
                + "VALUES('" + other.getProductName() + "'," + other.getSupplierID() + "," + other.getCategoryID() + "," + other.getMfgDate() + "," + other.getExpDate() + "," + other.getQuantity() + "," + other.getUnitPrice() + "," + other.getImgURL() + "," + other.getDescription() + ")";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    public int addProduct(Product other) {
        int n = 0;
        String sql = """
                   INSERT INTO [dbo].[Products]([ProductName],[SupplierID],[CategoryID],[MfgDate],[ExpDate],[Quantity],[UnitPrice],[ImgURL],[Description])
                    VALUES(?,?,?,?,?,?,?,?,?)""";

        try {
            PreparedStatement preState = conn.prepareStatement(sql);
            preState.setString(1, other.getProductName());
            preState.setInt(2, other.getSupplierID());
            preState.setInt(3, other.getCategoryID());
            preState.setString(4, other.getMfgDate());
            preState.setString(5, other.getExpDate());
            preState.setInt(6, other.getQuantity());
            preState.setDouble(7, other.getUnitPrice());
            preState.setString(8, other.getImgURL());
            preState.setString(9, other.getDescription());
            n = preState.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int deleteProduct(int pid) {
        int n = 0;
        String sql = "DELETE FROM [dbo].[Products] WHERE ProductID = " + pid;
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updateProduct(Product other) {
        int n = 0;
        String sql = """
                     UPDATE [dbo].[Products]
                        SET [ProductName] = ?
                           ,[SupplierID] = ?
                           ,[CategoryID] = ?
                           ,[MfgDate] = ?
                           ,[ExpDate] = ?
                           ,[Quantity] = ?
                           ,[UnitPrice] =?
                           ,[ImgURL] = ?
                           ,[Description] = ?
                      WHERE ProductID = ?""";
        try {
            PreparedStatement preState = conn.prepareStatement(sql);
            preState.setString(1, other.getProductName());
            preState.setInt(2, other.getSupplierID());
            preState.setInt(3, other.getCategoryID());
            preState.setString(4, other.getMfgDate());
            preState.setString(5, other.getExpDate());
            preState.setInt(6, other.getQuantity());
            preState.setDouble(7, other.getUnitPrice());
            preState.setString(8, other.getImgURL());
            preState.setString(9, other.getDescription());
            preState.setInt(10, other.getProductID());
            n = preState.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Vector<Product> getProduct(String sql) {
        Vector<Product> vector = new Vector();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int ProductID = rs.getInt("ProductID");
                String ProductName = rs.getString("ProductName");
                int SupplierID = rs.getInt("SupplierID");
                int CategoryID = rs.getInt("CategoryID");
                String MfgDate = rs.getString("MfgDate");
                String ExpDate = rs.getString("ExpDate");
                int Quantity = rs.getInt("Quantity");
                double UnitPrice = rs.getDouble("UnitPrice");
                String ImgURL = rs.getString("ImgURL");
                String Description = rs.getString("Description");
                Product product = new Product(ProductID, ProductName, SupplierID, CategoryID, MfgDate, ExpDate, Quantity, UnitPrice, ImgURL, Description);
                vector.add(product);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vector;
    }

    public int getTotalProduct(String sql) {
        int total = 0;
        PreparedStatement preState;
        try {
            preState = conn.prepareStatement(sql);
            ResultSet rs = preState.executeQuery();
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

        return total;
    }

    public static void main(String[] args) {
        DAOProduct dao = new DAOProduct();
        int n = dao.updateProduct(new Product(2007, "Indomies", 1, 1, "2024/02/02", "2024/03/03", 40, 0.2, "abc.img", "Is good"));

        if(n!=0){
            System.out.println("Success");
        }else{
            System.out.println("Falier");
        }
    }
}
