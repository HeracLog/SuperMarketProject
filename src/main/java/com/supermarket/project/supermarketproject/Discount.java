package com.supermarket.project.supermarketproject;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Discount {

    public static void allDiscount(ArrayList<Product> p, int discountPercent)
    {

        for (Product prod :p)
        {
            prod.setBuyPrice(prod.getBuyPrice() - prod.getBuyPrice()* (discountPercent/100));
        }
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for (Product prod :p)
                {
                    prod.setBuyPrice(prod.getBuyPrice()/(1- (discountPercent/100)));
                }
                timer.cancel();
            }
        }, 24 * 60 * 60 * 1000);

    }
    public static void exclusiveDiscount(Product[] p, int discountPercent)
    {
        for (Product prod :p)
        {
            prod.setBuyPrice(prod.getBuyPrice() - prod.getBuyPrice()* (discountPercent/100));
        }
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for (Product prod :p)
                {
                    prod.setBuyPrice(prod.getBuyPrice()/(1- (discountPercent/100)));
                }
                timer.cancel();
            }
        }, 7* 24 * 60 * 60 * 1000);

    }

}


