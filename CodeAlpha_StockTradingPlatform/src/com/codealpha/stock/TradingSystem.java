
package com.codealpha.stock;

import java.util.ArrayList;

public class TradingSystem {

    private ArrayList<Stock> stocks;
    private ArrayList<Portfolio> portfolio;

    private double balance;

    public TradingSystem() {

        balance = 100000;

        stocks = new ArrayList<>();
        portfolio = new ArrayList<>();

        stocks.add(new Stock("TCS",3500));
        stocks.add(new Stock("Infosys",1600));
        stocks.add(new Stock("Reliance",2800));
        stocks.add(new Stock("HDFC Bank",1700));
    }

    public void showStocks(){

        System.out.println("\n========================================");
        System.out.println("           AVAILABLE STOCKS");
        System.out.println("========================================");

        System.out.printf("%-15s %-10s%n","Stock","Price");

        System.out.println("----------------------------------------");

        for(Stock stock:stocks){

            System.out.printf("%-15s ₹%.2f%n",
                    stock.getStockName(),
                    stock.getPrice());
        }

        System.out.println("----------------------------------------");
        System.out.println("Available Balance : ₹"+balance);
    }
    // Buy Stock
    public void buyStock(String stockName, int quantity) {

        for (Stock stock : stocks) {

            if (stock.getStockName().equalsIgnoreCase(stockName)) {

                double totalCost = stock.getPrice() * quantity;

                if (totalCost > balance) {
                    System.out.println("Insufficient Balance!");
                    return;
                }

                balance -= totalCost;

                for (Portfolio p : portfolio) {

                    if (p.getStockName().equalsIgnoreCase(stockName)) {
                        p.addQuantity(quantity);
                        System.out.println("Stock Purchased Successfully!");
                        return;
                    }
                }

                portfolio.add(new Portfolio(stockName, quantity));
                System.out.println("Stock Purchased Successfully!");
                return;
            }
        }

        System.out.println("Stock Not Found!");
    }

    // Sell Stock
    public void sellStock(String stockName, int quantity) {

        for (Portfolio p : portfolio) {

            if (p.getStockName().equalsIgnoreCase(stockName)) {

                if (p.getQuantity() < quantity) {
                    System.out.println("Not enough shares!");
                    return;
                }

                for (Stock stock : stocks) {

                    if (stock.getStockName().equalsIgnoreCase(stockName)) {

                        p.removeQuantity(quantity);
                        if (p.getQuantity() == 0) {
                            portfolio.remove(p);
                        }
                        balance += stock.getPrice() * quantity;

                        System.out.println("Stock Sold Successfully!");
                        return;
                    }
                }
            }
        }

        System.out.println("Stock Not Found in Portfolio!");
    }

    // Show Portfolio
    public void showPortfolio() {

        if (portfolio.isEmpty()) {

            System.out.println("\nPortfolio is Empty.");
            return;
        }

        System.out.println("\n========================================");
        System.out.println("             MY PORTFOLIO");
        System.out.println("========================================");

        System.out.printf("%-15s %-10s%n", "Stock", "Quantity");

        System.out.println("----------------------------------------");

        for (Portfolio p : portfolio) {

            System.out.printf("%-15s %-10d%n",
                    p.getStockName(),
                    p.getQuantity());
        }

        System.out.println("----------------------------------------");
        System.out.println("Available Balance : ₹" + balance);
    }

}
