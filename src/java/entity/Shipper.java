/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Admin
 */
public class Shipper {

    private int ShipperID;
    private String ShipperName;
    private String Sex;
    private String Address;
    private String Email;
    private String Phone;

    public Shipper(int ShipperID, String ShipperName, String Sex, String Address, String Email, String Phone) {
        this.ShipperID = ShipperID;
        this.ShipperName = ShipperName;
        this.Sex = Sex;
        this.Address = Address;
        this.Email = Email;
        this.Phone = Phone;
    }

    public Shipper(String ShipperName, String Sex, String Address, String Email, String Phone) {
        this.ShipperName = ShipperName;
        this.Sex = Sex;
        this.Address = Address;
        this.Email = Email;
        this.Phone = Phone;
    }

    public Shipper() {
    }

    public int getShipperID() {
        return ShipperID;
    }

    public void setShipperID(int ShipperID) {
        this.ShipperID = ShipperID;
    }

    public String getShipperName() {
        return ShipperName;
    }

    public void setShipperName(String ShipperName) {
        this.ShipperName = ShipperName;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    @Override
    public String toString() {
        return "Shipper{" + "ShipperID=" + ShipperID + ", ShipperName=" + ShipperName + ", Sex=" + Sex + ", Address=" + Address + ", Email=" + Email + ", Phone=" + Phone + '}';
    }
    
    
}
