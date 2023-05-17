package com.supermarket.project.supermarketproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;


public class RegularClient extends Person{

    private int age;
    private String[] address;
    private Date initialDate;
    private Date nextCheck;
    private int moneySpent;
    private boolean isGolden;
    private int goldenClientIndex;
    private boolean stored;
    private String passwordHash;

    public boolean isStored() {
        return stored;
    }

    public void setStored(boolean stored) {
        this.stored = stored;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public RegularClient(String id, String name, int age, String phoneNum, String street , String town, String homeNum, String passwordHash){
        this.address = new String[3];

        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneNum = phoneNum;
        this.address[0] = street;
        this.address[1] = town;
        this.address[2] = homeNum;
        this.initialDate = new Date();
        this.nextCheck = new Date();
        this.moneySpent = 0;
        this.nextCheck.setMonth(this.initialDate.getMonth() + 1);
        this.isGolden = false;
        this.passwordHash = passwordHash;
        if (!isGolden) {
            GenreateQR.generateQRCode(toString(), name, id);
            DataStore.store(this);
        }
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getPhoneNum() {
        return phoneNum;
    }

    @Override
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
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
    @Override
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
                ", telephoneNum='" + phoneNum + '\'' +
                ", address=" + Arrays.toString(address) +
                '}';
    }

    public void buy(ArrayList<Product> p, Staff s){
        if (!isGolden) {
            StringBuilder x = new StringBuilder();
            Date z = new Date();
            x.append(z + "\n");
            x.append("Name" + "     ");
            x.append("Buy price" + "  ");
            x.append("Quantity" + "  ");
            x.append("Total price" + "  \n");
            check();
            s.sell(p);
            double currentReceipt = 0;
            for (Product y : p) {
                x.append(y.getName() + "     ");
                x.append(y.getBuyPrice() + "       ");
                x.append(y.getQuantity() + "      ");
                x.append(y.getQuantity() * y.getBuyPrice() + "  \n");


                y.setNumInStock(y.getNumInStock() - y.getQuantity());
                moneySpent += (int) y.getBuyPrice() * y.getQuantity();
                currentReceipt += y.getBuyPrice() * y.getQuantity();
                y.setProductsSold(y.getProductsSold() + y.getQuantity());
                x.append("\n");
            }
            x.append("staff:" + s.getName() + "  ");
            x.append(s.getId());
            x.append(s.getPrivatecard().getPOS().getId() + "\n");

            x.append("totalprice " + currentReceipt);
            if (moneySpent >= 4000) {
                currentReceipt -= currentReceipt * 0.05;
                String o = "priceafterdiscount";
                System.out.println("priceafterdiscount" + currentReceipt);
                x.append("priceafterdiscount" + currentReceipt);
                x.append("thank you for shopping with us");


            }
            invoice.x(x.toString(), name, id);
        }
        else {
            for (GoldenClients gc :ApplicationMain.goldenClients)
            {
                if (gc.getName() == this.name && gc.getId() == this.id)
                {
                    gc.buy(p,s);
                }
            }
        }

    }
    public void isGoldenClients() {
        Date currentDate = new Date();
        if (currentDate.getYear() - getInitialDate().getYear() >= 5){
            GoldenClients c = new GoldenClients(this.id,this.name, this.age,this.phoneNum, this.address[0], this.address[1],this.address[2],null,null,passwordHash);
            isGolden = true;
            ApplicationMain.goldenClients.add(c);
            ApplicationMain.serial(ApplicationMain.goldenClients,"GoldenClients");
        }

    }

}