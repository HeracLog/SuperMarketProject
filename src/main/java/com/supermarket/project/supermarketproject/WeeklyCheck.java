package com.supermarket.project.supermarketproject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

public class WeeklyCheck {
    public static void checkStock(ArrayList<Product> p)
    {
        for (Product prod :p)
        {
            if (prod.getNumInStock() < 10)
            {
                System.out.println("Product " + prod.getName() + " is low on stock, Stock soon!!!");
            }
        }
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                checkStock(p);
                timer.cancel();
            }
        }, 24 * 60 * 60 * 1000* 7);
    }
    public static void weeklyMostSold(ArrayList<Product> p)
    {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                mostSold(p);
                timer.cancel();
            }
        }, 24 * 60 * 60 * 1000* 7);
    }
    public static void mostSold(ArrayList<Product> p)
    {
        LinkedList<Product> sorted = new LinkedList<>();
        for (Product prod: p)
        {
            boolean added = false;
            if (sorted.isEmpty())
            {
                sorted.add(prod);
            }
            else
            {
                if (prod.getProductsSold() >= sorted.getFirst().getProductsSold())
                {
                    sorted.addFirst(prod);
                    added = true;
                }else {
                    for (Product prodSort : sorted) {
                        if (prod.getProductsSold() >= prodSort.getProductsSold()) {
                            sorted.add(sorted.indexOf(prodSort), prod);
                            added = true;
                            break;
                        }
                    }
                    if (!added) sorted.addLast(prod);
                }
            }
        }
        int mostSoldNum =0;
        for (Product product: sorted)
        {
            if (mostSoldNum >10) break;
            System.out.println("Product " + product.getName()+ " sold " +product.getProductsSold());
            mostSoldNum++;
        }
    }
}
