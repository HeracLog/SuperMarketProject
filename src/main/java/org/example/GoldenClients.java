package org.example;

import java.util.Date;
public class GoldenClients extends RegularClient{
    private Date birthDay;
    private Product favoriteProduct;

    public GoldenClients(String id, String name, int age, String telephoneNum, String street, String town, String homeNum, Date birthDay, Product favoriteProduct) {
        super(id, name, age, telephoneNum, street, town, homeNum);
        this.birthDay = birthDay;
        this.favoriteProduct = favoriteProduct;
    }

    @Override
    public void buy(Product[] p, Staff s) {
        this.check();
        s.sell(p);
        double currentReceipt = 0;
        boolean favourtieBought = false;
        for (Product y : p) {
            y.setNumInStock(y.getNumInStock() - 1);
            setMoneySpent(getMoneySpent()+(int) y.getBuyPrice());
            if (y.getName() == favoriteProduct.getName())
            {
                favourtieBought = true;
            }
            currentReceipt += y.getBuyPrice();
        }
        if (getMoneySpent() >= 4000) {
            currentReceipt -= currentReceipt * 0.05;
        }
        if (isBday())
        {
            currentReceipt -= currentReceipt * 0.1;
        }
        if (favourtieBought)
        {
            currentReceipt -= currentReceipt * 0.2;
        }
        currentReceipt -= currentReceipt * 0.02;
    }
    private boolean isBday()
    {
        Date now = new Date();
        return now.getMonth() == birthDay.getMonth() && now.getDay() == birthDay.getDay();
    }
}
