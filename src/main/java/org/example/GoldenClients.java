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


}
