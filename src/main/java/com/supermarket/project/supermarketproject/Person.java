/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermarket.project.supermarketproject;


import java.io.Serializable;

public abstract class Person implements Serializable {
    protected String id ;
    protected String name ;
    protected String phoneNum;
    
    public abstract String getId();
    public abstract  void setId(String id);
    public abstract String getName();
    public abstract void setName(String name);
    public abstract String getPhoneNum();
    public abstract void setPhoneNum(String phoneNum);
    public abstract void check();
    
}
