/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Cart;
import java.util.Vector;
import  java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DAOCart extends DBConnection{
    public Cart getCart(int pid){
        Cart cart = null;
        Vector<Cart> vector = new Vector<>();
        String sql = "select p.ProductID,p.ProductName,p.UnitPrice,p.ImgURL  \n" +
"from Products p where p.ProductID = "+pid;
        try {
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
            cart = new Cart(rs.getInt(1), rs.getString(2), rs.getDouble(3),rs.getString(4),
                0,0);
         
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCart.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cart;
    }
    
    public static void main(String[] args) {
        DAOCart dao = new DAOCart();
        Cart cart = dao.getCart(50);
        System.out.println(cart);
    }
}
