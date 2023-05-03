package org.example;

public class Product {
    private int ID;
    private String name;
    private String category;
    private double buyPrice;
    private double sellingPrice;
    private String expiryDate;
    private int numInStock;

    public Product(int ID, String name, String category, double buyPrice, double sellingPrice, String expiryDate, int numInStock) {
        this.ID= ID;
        this.name = name;
        this.category = category;
        this.buyPrice = buyPrice;
        this.sellingPrice = sellingPrice;
        this.expiryDate = expiryDate;
        this.numInStock = numInStock;
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

    public String getExpiryDate() {
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

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setNumInStock(int numInStock) {
        this.numInStock = numInStock;
    }

    public void addStock(int num) {
        numInStock += num;
    }

    public void removeStock(int num) {
        if (numInStock - num >= 0) {
            numInStock -= num;
        }
    }

    public double calculateProfit() {
        return (sellingPrice - buyPrice) * numInStock;
    }
}
