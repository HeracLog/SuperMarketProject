package com.supermarket.project.supermarketproject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Product {
    private int ID;
    private String name;
    private String category;
    private double buyPrice;
    private Date expiryDate;
    private int numInStock;
    private int productsSold;
    private boolean stored;
    private int quantity;

    public boolean isStored() {
        return stored;
    }

    public void setStored(boolean stored) {
        this.stored = stored;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static ArrayList<Product> productList = new ArrayList<>();

    public Product(int ID, String name, String category, double buyPrice, String expiryDate, int numInStock, int Prod){
        this.ID= ID;
        this.name = name;
        this.category = category;
        this.buyPrice = buyPrice;
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
        try {
            this.expiryDate = ft.parse(expiryDate);
        }
        catch (ParseException pe)
        {
            pe.printStackTrace();
        }
        this.numInStock = numInStock;
        // Add the new product instance to the productList ArrayList
        productList.add(this);
        this.productsSold = Prod;
        GenreateQR.generateQRCode(toString(),name,""+ID);
        DataStore.store(this);
    }
    public Product(int ID, String name, String category, double buyPrice, Date expiryDate, int numInStock, int Prod, int quantity){
        this.ID= ID;
        this.name = name;
        this.category = category;
        this.buyPrice = buyPrice;
        this.expiryDate = expiryDate;
        this.numInStock = numInStock;
        // Add the new product instance to the productList ArrayList
        productList.add(this);
        this.quantity = quantity;
        this.productsSold = Prod;
        GenreateQR.generateQRCode(toString(),name,""+ID);
        DataStore.store(this);

    }

    public int getID() {
        return ID;     
        }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public int getNumInStock() {
        return numInStock;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setNumInStock(int numInStock) {
        this.numInStock = numInStock;
    }

    public void addStock(int num) {
        numInStock += num;
    }

    public int getProductsSold() {
        return productsSold;
    }

    public void setProductsSold(int productsSold) {
        this.productsSold = productsSold;
    }

    public boolean isExpired() {
        return new Date().after(expiryDate);
    }
    public void checkExpireDate(ArrayList<Product> productList) {

        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).isExpired()) {
                System.out.println(productList.get(i).getName() + " is expired.");
                productList.remove(i);
                i--;
            } else {
                System.out.println(productList.get(i).getName() + " is not expired.");
            }
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", buyPrice=" + buyPrice +
                ", expiryDate=" + expiryDate +
                ", numInStock=" + numInStock +
                '}';
    }
}
