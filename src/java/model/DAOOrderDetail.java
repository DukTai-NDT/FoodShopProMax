/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.OrderDetail;
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
public class DAOOrderDetail extends DBConnection {

    public int insertOrderDetail(OrderDetail other) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[OrderDetails] ([OrderID] ,[ProductID] ,[UnitPrice] ,[Quantity] ,[Discount] ,[VAT] ,[Freight])\n"
                + "VALUES(" + other.getOrderID() + "," + other.getProductID() + "," + other.getUnitPrice() + "," + other.getQuantity() + "," + other.getDiscount() + "," + other.getVAT() + "," + other.getFreight() + ")";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrderDetail.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    public int addOrderDetail(OrderDetail other) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[OrderDetails] ([OrderID] ,[ProductID] ,[UnitPrice] ,[Quantity] ,[Discount] ,[VAT] ,[Freight])\n"
                + "VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement preState = conn.prepareStatement(sql);
            preState.setInt(1, other.getOrderID());
            preState.setInt(2, other.getProductID());
            preState.setDouble(3, other.getUnitPrice());
            preState.setInt(4, other.getQuantity());
            preState.setDouble(5, other.getDiscount());
            preState.setDouble(6, other.getVAT());
            preState.setDouble(7, other.getFreight());

            n = preState.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DAOOrderDetail.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    public int deleteOrderDetail(int oid, int pid) {
        int n = 0;
        String sql = "DELETE FROM [dbo].[OrderDetails] WHERE OrderID = " + oid + " and ProductID = " + pid;

        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(DAOOrderDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;

    }

    public int updateOrderDetail(OrderDetail other) {
        int n = 0;
        String sql = """
                    UPDATE [dbo].[OrderDetails]
                        SET [UnitPrice] = ?
                           ,[Quantity] = ?
                           ,[Discount] = ?
                           ,[VAT] = ?
                           ,[Freight] = ?
                      WHERE OrderID = ? and ProductID = ? """;

        try {
            PreparedStatement preState = conn.prepareStatement(sql);

            preState.setDouble(1, other.getUnitPrice());
            preState.setInt(2, other.getQuantity());
            preState.setDouble(3, other.getDiscount());
            preState.setDouble(4, other.getVAT());
            preState.setDouble(5, other.getFreight());
            preState.setInt(6, other.getOrderID());
            preState.setInt(7, other.getProductID());
            n = preState.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrderDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Vector<OrderDetail> getOrderDetail(String sql) {
        Vector<OrderDetail> vector = new Vector<>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int OrderID = rs.getInt("OrderID");
                int ProductID= rs.getInt("ProductID");
                double UnitPrice = rs.getDouble("UnitPrice");
                int Quantity = rs.getInt("Quantity");
                double Discount = rs.getDouble("Discount");
                double VAT = rs.getDouble("VAT");
                double Freight = rs.getDouble("Freight");
                
                OrderDetail orderDetail = new OrderDetail(OrderID, ProductID, UnitPrice, Quantity, Discount, VAT, Freight);
                vector.add(orderDetail);

            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOOrderDetail.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vector;
    }

    public static void main(String[] args) {
        DAOOrderDetail dao = new DAOOrderDetail();
//        int n = dao.updateOrderDetail(new OrderDetail(21, 21, 4.5, 4, 0, 0, 1));
//        if (n != 0) {
//            System.out.println("Sucsess");
//        } else {
//            System.out.println("Failer");
//        }
Vector<OrderDetail> vector = dao.getOrderDetail("Select * from OrderDetails");
        for (OrderDetail orderDetail : vector) {
            System.out.println(orderDetail);
        }
    }
}
