/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Bill;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.util.Vector;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class DAOBill extends DBConnection {

    public Vector<Bill> getBill(String sql) {

        Vector<Bill> vector = new Vector<>();

        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int OrderID = rs.getInt("OrderID");
                String OrderDate = rs.getString("OrderDate"),
                        DeliveryDate = rs.getString("DeliveryDate");
                String CustomerName = rs.getString("CustomerName");
                int ProductID = rs.getInt("ProductID");
                String ProductName = rs.getString("ProductName");

                double UnitPrice = rs.getDouble("UnitPrice");
                int Quantity = rs.getInt("Quantity");
                double Discount = rs.getDouble("Discount");
                String Status = rs.getString("Status");
                vector.add(new Bill(OrderID, OrderDate, DeliveryDate, CustomerName, ProductID, ProductName, UnitPrice, Quantity, Discount, Status));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOBill.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vector;
    }

    public Vector<Bill> getBillManager(String sql) {

        Vector<Bill> vector = new Vector<>();

        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int OrderID = rs.getInt("OrderID");
                String OrderDate = rs.getString("OrderDate"),
                        DeliveryDate = rs.getString("DeliveryDate");
                String CustomerName = rs.getString("CustomerName");

                String Status = rs.getString("Status");
                vector.add(new Bill(OrderID, OrderDate, DeliveryDate, CustomerName, Status));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOBill.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vector;
    }

    


    public static void main(String[] args) {
        DAOBill dod = new DAOBill();
       
        System.out.println("success");
        
//      Vector<Bill> vector = dod.getBill(sql);
//        
//       Bill bill = vector.get(vector.size()-1);
//        System.out.println(bill.getOrderID());

    }
}
