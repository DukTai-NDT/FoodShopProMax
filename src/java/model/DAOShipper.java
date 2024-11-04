/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Shipper;
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
public class DAOShipper extends DBConnection {

    public int insertShipper(Shipper other) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Shippers] ([ShipperName] ,[Sex] ,[Address] ,[Email] ,[Phone])\n"
                + "VALUES('" + other.getShipperName() + "','" + other.getSex() + "','" + other.getAddress() + "','" + other.getEmail() + "','" + other.getPhone() + "')";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOShipper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int addShipper(Shipper other) {
        int n = 0;
        String sql = """
                     INSERT INTO [dbo].[Shippers] ([ShipperName] ,[Sex] ,[Address] ,[Email] ,[Phone])
                     VALUES(?,?,?,?,?)
                     """;
        try {
            PreparedStatement preState = conn.prepareStatement(sql);
            preState.setString(1, other.getShipperName());
            preState.setString(2, other.getSex());
            preState.setString(3, other.getAddress());
            preState.setString(4, other.getEmail());
            preState.setString(5, other.getPhone());
            n = preState.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOShipper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int deleteShipper(int sid) {
        int n = 0;
        String sql = "DELETE FROM [dbo].[Shippers]  WHERE ShipperID = " + sid;
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOShipper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    public int updateShipper(Shipper other) {
        int n = 0;
        String sql = """
                     UPDATE [dbo].[Shippers]
                        SET [ShipperName] = ?
                           ,[Sex] = ?
                           ,[Address] = ?
                           ,[Email] = ?
                           ,[Phone] = ?
                      WHERE ShipperID = ?
                     """;
        try {
            PreparedStatement preState = conn.prepareStatement(sql);
            preState.setString(1, other.getShipperName());
            preState.setString(2, other.getSex());
            preState.setString(3, other.getAddress());
            preState.setString(4, other.getEmail());
            preState.setString(5, other.getPhone());
            preState.setInt(6, other.getShipperID());
            n = preState.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOShipper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Vector<Shipper> getShipper(String sql) {
        Vector<Shipper> vector = new Vector<>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int ShipperID = rs.getInt("ShipperID");
                String ShipperName = rs.getString("ShipperName");
                String Sex = rs.getString("Sex");
                String Address = rs.getString("Address");
                String Email = rs.getString("Email");
                String Phone = rs.getString("Phone");

                Shipper shipper = new Shipper(ShipperID, ShipperName, Sex, Address, Email, Phone);
                vector.add(shipper);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOShipper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vector;
    }
    public static void main(String[] args) {
        DAOShipper dao = new DAOShipper();
         Vector<Shipper> vector = dao.getShipper("select * from Shippers");
         for (Shipper shipper : vector) {
             System.out.println(shipper);
        }
    }
}
