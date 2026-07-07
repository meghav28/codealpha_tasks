package com.codealpha.hotel;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Hotel hotel = new Hotel();

        int choice;

        do {

            System.out.println("\n========= HOTEL RESERVATION SYSTEM =========");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View Bookings");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    hotel.showRooms();
                    break;

                case 2:

                    System.out.print("Enter Room Number: ");
                    int roomNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Customer Name: ");
                    String name = sc.nextLine();

                    boolean booked = hotel.bookRoom(roomNo, name);

                    if (booked) {
                        hotel.processPayment(roomNo);
                    }

                    break;

                case 3:
                    System.out.print("Enter Room Number: ");
                    roomNo = sc.nextInt();

                    hotel.cancelBooking(roomNo);
                    break;

                case 4:
                    hotel.showBookings();
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