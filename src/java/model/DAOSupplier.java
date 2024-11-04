/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Supplier;
import java.util.Vector;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DAOSupplier extends DBConnection {

    public int insertSupplier(Supplier other) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Suppliers] ([SupplierName] ,[Address] ,[Hotline])\n"
                + "VALUES('" + other.getSupplierName() + "','" + other.getAddress() + "','" + other.getHotline() + "')";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    public int addSupplier(Supplier other) {
        int n = 0;
        String sql = """
                     INSERT INTO [dbo].[Suppliers] ([SupplierName] ,[Address] ,[Hotline])
                     VALUES(?,?,?)
                     """;

        try {
            PreparedStatement preState = conn.prepareStatement(sql);
            preState.setString(1, other.getSupplierName());
            preState.setString(2, other.getAddress());
            preState.setString(3, other.getHotline());
            n = preState.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int deleteSupplier(int sid) {
        int n = 0;
        String sql = "DELETE FROM [dbo].[Suppliers]\n"
                + "      WHERE SupplierID = " + sid;
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updateSupplier(Supplier other) {
        int n = 0;
        String sql = """
                     UPDATE [dbo].[Suppliers]
                        SET [SupplierName] = ?
                           ,[Address] = ?
                           ,[Hotline] = ?
                      WHERE SupplierID = ?
                     """;
        try {
            PreparedStatement preState = conn.prepareStatement(sql);
            preState.setString(1, other.getSupplierName());
            preState.setString(2, other.getAddress());
            preState.setString(3, other.getHotline());
            preState.setInt(4, other.getSupplierID());
            n = preState.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    public Vector<Supplier> getSupplier(String sql) {
        Vector<Supplier> vector = new Vector<>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int SupplierID = rs.getInt("SupplierID");
                String SupplierName = rs.getString("SupplierName");
                String Address = rs.getString("Address");
                String Hotline = rs.getString("Hotline");
                
                Supplier supplier = new Supplier(SupplierID, SupplierName, Address, Hotline);
                
                vector.add(supplier);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vector;
    }
    public static void main(String[] args) {
        DAOSupplier dao = new DAOSupplier();
         Vector<Supplier> vector = dao.getSupplier("Select * from Suppliers");
         
         for (Supplier supplier : vector) {
             System.out.println(supplier);
        }
    }
}
