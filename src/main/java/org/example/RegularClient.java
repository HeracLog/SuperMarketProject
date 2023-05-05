/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example;

import java.util.ArrayList;
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

    public RegularClient(String id, String name, int age, String telephoneNum,String street ,String town,String homeNum) {
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
    private void check(){
       Date now = new Date();
       if(now.getMonth() >= this.nextCheck.getMonth()&& now.getDay() >= this.nextCheck.getDay()){
          this.moneySpent = 0;
          this.nextCheck= now;
          this.nextCheck.setMonth(now.getMonth()+1);
          }
       
        }
    public void buy(Product[] p,Staff s){
        check();
        s.sell(p);
        double currentReceipt = 0;
        for(Product y:p){
                moneySpent+= (int) y.getBuyPrice();
                currentReceipt+=y.getBuyPrice();
                }
        if(moneySpent >= 4000){
            currentReceipt-= currentReceipt*0.05;
        }
            
        }
}
