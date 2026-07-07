
package com.codealpha.stock;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TradingSystem trading = new TradingSystem();

        int choice;

        do {

            System.out.println("\n========== STOCK TRADING PLATFORM ==========");
            System.out.println("1. View Stocks");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    trading.showStocks();
                    break;

                case 2:

                    System.out.print("Enter Stock Name: ");
                    String buyStock = sc.nextLine();

                    System.out.print("Enter Quantity: ");
                    int buyQty = sc.nextInt();

                    trading.buyStock(buyStock, buyQty);
                    break;

                case 3:


                    System.out.print("Enter Stock Name: ");
                    String sellStock = sc.nextLine();

                    System.out.print("Enter Quantity: ");
                    int sellQty = sc.nextInt();

                    trading.sellStock(sellStock, sellQty);
                    break;

                case 4:
                    trading.showPortfolio();
                    break;

                case 5:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}

