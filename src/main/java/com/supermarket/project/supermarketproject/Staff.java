package com.supermarket.project.supermarketproject;

import java.util.Date;

public class Staff extends Person {
    
    private double salary;
    private String address;
    private double invoices;
    private Date initialDate;
    private Date nextCheck;
    private boolean wasStored;

    public boolean isWasStored() {
        return wasStored;
    }

    public void setWasStored(boolean wasStored) {
        this.wasStored = wasStored;
    }

    public Staff(String id, String name, double salary, String phoneNum, String address) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.phoneNum = phoneNum;
        this.address = address;
        this.initialDate = new Date();
        this.nextCheck = new Date();
        this.nextCheck.setMonth(this.initialDate.getMonth() + 1);
        GenreateQR.generateQRCode(toString(),name,""+id);
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
       
    public void sell(Product[] p){
        for(Product y:p){
            invoices+=y.getBuyPrice();
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
}