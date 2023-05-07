package org.example;

import com.google.zxing.WriterException;

import java.io.IOException;
import java.util.Date;

public class Staff {
    private int id;
    private String name;
    private double salary;
    private String phoneNumber;
    private String address;
    private double invoices;
    private Date initialDate;
    private Date nextCheck;
    

    public Staff(int id, String name, double salary, String phoneNumber, String address) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.initialDate = new Date();
        this.nextCheck = new Date();
        this.nextCheck.setMonth(this.initialDate.getMonth() + 1);
        GenreateQR.generateQRCode(toString(),name,""+id);
        DataStore.store(this);
    }

    public int getId() {
        return id;
    }

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setId(int id) {
        this.id = id;
    }  

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }
     private void check(){
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
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}