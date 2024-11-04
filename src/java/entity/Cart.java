/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Admin
 */
public class Cart {
    private int ProductID;
    private String ProductName;
    private double UnitPrice;
    private String ImgURL;
    private int Quantity;
    private float Discount;

    public Cart(int ProductID, String ProductName, double UnitPrice, String ImgURL, int Quantity, float Discount) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.UnitPrice = UnitPrice;
        this.ImgURL = ImgURL;
        this.Quantity = Quantity;
        this.Discount = Discount;
    }
    

    

    

    public Cart() {
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public float getDiscount() {
        return Discount;
    }

    public void setDiscount(float Discount) {
        this.Discount = Discount;
    }

    public String getImgURL() {
        return ImgURL;
    }

    public void setImgURL(String ImgURL) {
        this.ImgURL = ImgURL;
    }

    @Override
    public String toString() {
        return "Cart{" + "ProductID=" + ProductID + ", ProductName=" + ProductName + ", UnitPrice=" + UnitPrice + ", Quantity=" + Quantity + ", Discount=" + Discount + ", ImgURL=" + ImgURL + '}';
    }

    
    
    
    
}
