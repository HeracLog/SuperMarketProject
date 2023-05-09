/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermarket.project.supermarketproject;

import java.util.Arrays;
import java.util.Date;


public class RegularClient {
    private String id;
    private String name;
    private int age;
    private String telephoneNum;
    private String[] address;
    private Date initialDate;
    private Date nextCheck;
    private int moneySpent;
    private boolean isGolden;
    private int goldenClientIndex;

    public RegularClient(String id, String name, int age, String telephoneNum,String street ,String town,String homeNum){
        this.address = new String[3];
        this.id = id;
        this.name = name;
        this.age = age;
        this.telephoneNum = telephoneNum;
        this.address[0] = street;
        this.address[1] = town;
        this.address[2] = homeNum;
        this.initialDate = new Date();
        this.nextCheck = new Date();
        this.moneySpent = 0;
        this.nextCheck.setMonth(this.initialDate.getMonth() + 1);
        this.isGolden = false;
        if (!isGolden) {
            GenreateQR.generateQRCode(toString(), name, id);
            DataStore.store(this);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTelephoneNum() {
        return telephoneNum;
    }

    public void setTelephoneNum(String telephoneNum) {
        this.telephoneNum = telephoneNum;
    }

    public String[] getAddress() {
        return address;
    }

    public void setAddress(String[] address) {
        this.address = address;
    }
    public Date getInitialDate() {
        return initialDate;
    }
    public void check(){
       Date now = new Date();
       if(now.getMonth() >= this.nextCheck.getMonth()&& now.getDay() >= this.nextCheck.getDay()){
          this.moneySpent = 0;
          this.nextCheck= now;
          this.nextCheck.setMonth(now.getMonth()+1);
          }
       
        }

    public int getMoneySpent() {
        return moneySpent;
    }

    public void setMoneySpent(int moneySpent) {
        this.moneySpent = moneySpent;
    }

    @Override
    public String toString() {
        return "RegularClient{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", telephoneNum='" + telephoneNum + '\'' +
                ", address=" + Arrays.toString(address) +
                '}';
    }

    public void buy(Product[] p, Staff s){
        if (!isGolden) {
            isGoldenClients(this);
            check();
            s.sell(p);
            double currentReceipt = 0;
            for (Product y : p) {
                y.setNumInStock(y.getNumInStock() - 1);
                moneySpent += (int) y.getBuyPrice();
                currentReceipt += y.getBuyPrice();
                y.setProductsSold(y.getProductsSold() + 1);
            }
            if (moneySpent >= 4000) {
                currentReceipt -= currentReceipt * 0.05;
            }
        }
        else{
            Main.goldenClients.get(goldenClientIndex).buy(p,s);
        }
        }
    public void isGoldenClients(RegularClient c) {
        Date currentDate = new Date();
        if (currentDate.getYear() - getInitialDate().getYear() >= 5){
            c = new GoldenClients(this.id,this.name, this.age,this.telephoneNum, this.address[0], this.address[1],this.address[2],null,null);
}
       
    }
   
}
