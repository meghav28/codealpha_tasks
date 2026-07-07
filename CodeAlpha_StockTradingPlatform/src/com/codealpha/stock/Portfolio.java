
package com.codealpha.stock;

public class Portfolio {

    private String stockName;
    private int quantity;

    public Portfolio(String stockName, int quantity) {
        this.stockName = stockName;
        this.quantity = quantity;
    }

    public String getStockName() {
        return stockName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int qty) {
        quantity += qty;
    }

    public void removeQuantity(int qty) {
        quantity -= qty;
    }
}
