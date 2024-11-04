/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Category;
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
public class DAOCategory extends DBConnection{
    public int insertCategory(Category other){
        int n = 0;
        String sql = "INSERT INTO [dbo].[Categories]\n" +
"           ([CategoryName])\n" +
"     VALUES\n" +
"           ('"+other.getCategoryName()+"')";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return n;
    }
    public int addCategory(Category other){
        int n =0;
        String sql = "INSERT INTO [dbo].[Categories]\n" +
"           ([CategoryName])\n" +
"     VALUES\n" +
"           (?)";
        
        try {
            PreparedStatement preState = conn.prepareStatement(sql);
            preState.setString(1, other.getCategoryName());
            n = preState.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    public int deleteCategory(int cid){
        int n = 0;
        String sql = "DELETE FROM Categories WHERE CategoryID = "+cid;
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return n;
    }
    public int updateCategory(Category other){
        int n = 0;
        String sql = "UPDATE Categories SET [CategoryName] = ? " +
" WHERE CategoryID = ?";
        try {
            PreparedStatement preState = conn.prepareStatement(sql);
            preState.setString(1, other.getCategoryName());
            preState.setInt(2, other.getCategoryID());
            n = preState.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
      }
    public Vector<Category> getCategory(String sql){
        Vector<Category> vector = new Vector<>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int CategoryID = rs.getInt("CategoryID");
                String CategoryName = rs.getString("CategoryName");
                Category category = new Category(CategoryID, CategoryName);
                vector.add(category);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }
    public static void main(String[] args) {
       DAOCategory dao = new DAOCategory();
//       int n = dao.updateCategory(new Category(1004,"HoaQua"));
//       if(n != 0){
//           System.out.println("Success");
//       }else{
//           System.out.println("failed");
//       }

    Vector<Category> vector = dao.getCategory("Select * from Categories");
        for (Category category : vector) {
            System.out.println(category);
        }
    }
}