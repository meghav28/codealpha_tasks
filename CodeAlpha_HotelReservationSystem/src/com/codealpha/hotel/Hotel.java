
package com.codealpha.hotel;

import java.util.ArrayList;

public class Hotel {

    private ArrayList<Room> rooms;
    private ArrayList<Booking> bookings;

    public Hotel() {

        rooms = new ArrayList<>();
        bookings = new ArrayList<>();

        rooms.add(new Room(101, "Standard"));
        rooms.add(new Room(102, "Standard"));
        rooms.add(new Room(201, "Deluxe"));
        rooms.add(new Room(202, "Deluxe"));
        rooms.add(new Room(301, "Suite"));
    }

    public void showRooms() {

        System.out.println("\n==================================================");
        System.out.println("                 HOTEL ROOMS");
        System.out.println("==================================================");

        System.out.printf("%-10s %-15s %-15s%n",
                "Room No", "Type", "Status");

        System.out.println("--------------------------------------------------");

        for (Room room : rooms) {

            String status = room.isBooked() ? "Booked" : "Available";

            System.out.printf("%-10d %-15s %-15s%n",
                    room.getRoomNumber(),
                    room.getRoomType(),
                    status);
        }
    }
    // Book a room
    public boolean bookRoom(int roomNumber, String customerName) {

        for (Room room : rooms) {

            if (room.getRoomNumber() == roomNumber) {

                if (!room.isBooked()) {

                    room.bookRoom();
                    bookings.add(new Booking(customerName, room));

                    System.out.println("\nBooking Successful!");
                    return true;

                } else {

                    System.out.println("\nRoom is already booked.");
                    return false;
                }
            }
        }

        System.out.println("\nRoom not found.");
        return false;
    }




    // Cancel booking
    public void cancelBooking(int roomNumber) {

        for (Booking booking : bookings) {

            if (booking.getRoom().getRoomNumber() == roomNumber) {

                booking.getRoom().cancelBooking();
                bookings.remove(booking);

                System.out.println("Booking Cancelled Successfully!");
                return;
            }
        }

        System.out.println("Booking not found.");
    }

    // View all bookings
    public void showBookings() {

        if (bookings.isEmpty()) {

            System.out.println("\nNo bookings available.");
            return;
        }

        System.out.println("\n==================================================");
        System.out.println("                BOOKING DETAILS");
        System.out.println("==================================================");

        System.out.printf("%-20s %-10s %-15s%n",
                "Customer",
                "Room",
                "Type");

        System.out.println("--------------------------------------------------");

        for (Booking booking : bookings) {

            System.out.printf("%-20s %-10d %-15s%n",

                    booking.getCustomerName(),

                    booking.getRoom().getRoomNumber(),

                    booking.getRoom().getRoomType());
        }
    }
    public void processPayment(int roomNumber) {

        int amount;

        switch (roomNumber) {

            case 101:
            case 102:
                amount = 2000;
                break;

            case 201:
            case 202:
                amount = 3500;
                break;

            case 301:
                amount = 5000;
                break;

            default:
                System.out.println("Invalid Room Number.");
                return;
        }

        System.out.println("\n================================");
        System.out.println("        PAYMENT RECEIPT");
        System.out.println("================================");
        System.out.println("Room Number : " + roomNumber);
        System.out.println("Amount Paid : ₹" + amount);
        System.out.println("Payment Status : SUCCESS");
        System.out.println("================================");
    }
}
