package com.supermarket.project.supermarketproject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Staff extends Person {
    
    private double salary;
    private String address;
    private double invoices;
    private Date initialDate;
    private Date nextCheck;
    private boolean wasStored;
    private int cardid;
    private privatecard privatecard;

    private String passwordHash;

    public boolean isWasStored() {
        return wasStored;
    }

    public void setWasStored(boolean wasStored) {
        this.wasStored = wasStored;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public Staff(String id, String name, double salary, String phoneNum, String address, String username, String passwordHash) {
        this.privatecard=new privatecard();
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.phoneNum = phoneNum;
        this.address = address;
        this.initialDate = new Date();
        this.nextCheck = new Date();
        this.nextCheck.setMonth(this.initialDate.getMonth() + 1);
        GenreateQR.generateQRCode(toString(),name,""+id);
        this.passwordHash = passwordHash;
        DataStore.store(this);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public double getSalary() {
        check();
        if(invoices >= 100000){
            return salary + 500;
        }
        else{
        return salary;}
    }

    @Override
    public String getPhoneNum() {
        return phoneNum;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }  

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public privatecard getPrivatecard() {
        return privatecard;
    }

    @Override
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public void check(){
       Date now = new Date();
       if(now.getMonth() >= this.nextCheck.getMonth()&& now.getDay() >= this.nextCheck.getDay()){
           invoices = 0;
          this.nextCheck= now;
          this.nextCheck.setMonth(now.getMonth()+1);
          }
     }
       
    public void sell(ArrayList<Product> p){
        for(Product y:p){
            invoices+=y.getBuyPrice() * y.getQuantity();
        }
      }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", phoneNumber='" + this.phoneNum+ '\'' +
                ", address='" + address + '\'' +
                '}';
    }
     static class pointofsale implements Serializable{
         String id;
         public pointofsale(String id){
             this.id=id;
         }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
    static class privatecard implements Serializable {
        int cardid;
          static pointofsale pos=new pointofsale("333");

        public pointofsale getPOS() {
            return pos;
        }
        String username;

        public privatecard(int cardid, String username) {
            this.cardid = cardid;
            this.username = username;
        }

        public privatecard() {
        }

        public int getCardid() {
            return cardid;
        }

        public void setCardid(int cardid) {
            this.cardid = cardid;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}

