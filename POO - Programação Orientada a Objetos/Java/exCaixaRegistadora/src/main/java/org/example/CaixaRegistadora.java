package org.example;


public class CaixaRegistadora {
    private int itemCount;
    private double totalPrice;

    public CaixaRegistadora() {
        itemCount = 0;
        totalPrice = 0;
    }

    public void addItem(double price) {
        itemCount++;
        totalPrice += price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getItemCount(int Total) {
        return itemCount;
    }
    public void clear(){
        itemCount=0;
        totalPrice=0;
    }
}
