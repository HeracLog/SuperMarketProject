package org.example;

import java.util.Date;
import java.util.ArrayList;

public class Product {
    private int ID;
    private String name;
    private String category;
    private double buyPrice;
    private double sellingPrice;
    private Date expiryDate;
    private int numInStock;
    private int productsSold;

    public static ArrayList<Product> productList = new ArrayList<>();

    public Product(int ID, String name, String category, double buyPrice, double sellingPrice, Date expiryDate, int numInStock, int Prod) {
        this.ID= ID;
        this.name = name;
        this.category = category;
        this.buyPrice = buyPrice;
        this.sellingPrice = sellingPrice;
        this.expiryDate = expiryDate;
        this.numInStock = numInStock;
        // Add the new product instance to the productList ArrayList
        productList.add(this);
        this.productsSold = Prod;
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

    public double getSellingPrice() {
        return sellingPrice;
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

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
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

    public double calculateProfit() {
        return (sellingPrice - buyPrice) * numInStock;
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
}
