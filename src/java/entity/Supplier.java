/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Admin
 */
public class Supplier {

    private int SupplierID;
    private String SupplierName;
    private String Address;
    private String Hotline;

    public Supplier(int SupplierID, String SupplierName, String Address, String Hotline) {
        this.SupplierID = SupplierID;
        this.SupplierName = SupplierName;
        this.Address = Address;
        this.Hotline = Hotline;
    }

    public Supplier(String SupplierName, String Address, String Hotline) {
        this.SupplierName = SupplierName;
        this.Address = Address;
        this.Hotline = Hotline;
    }

    public Supplier() {
    }

    public int getSupplierID() {
        return SupplierID;
    }

    public void setSupplierID(int SupplierID) {
        this.SupplierID = SupplierID;
    }

    public String getSupplierName() {
        return SupplierName;
    }

    public void setSupplierName(String SupplierName) {
        this.SupplierName = SupplierName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getHotline() {
        return Hotline;
    }

    public void setHotline(String Hotline) {
        this.Hotline = Hotline;
    }

    @Override
    public String toString() {
        return "Supplier{" + "SupplierID=" + SupplierID + ", SupplierName=" + SupplierName + ", Address=" + Address + ", Hotline=" + Hotline + '}';
    }

}
