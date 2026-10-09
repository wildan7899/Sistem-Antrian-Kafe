package main;

import model.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("[   === SISTEM ANTRIAN KAFE ===   ]\n");
        
        // TODO: Tim Linked List - Buat class Node.java dan hubungkan dengan subclass Antrian
        // TODO: Tim Inheritance - Instansiasi subclass (Single/Double/Circular) di sini
        
        displayAdtOperations();
        demonstrateCustomer();
        
        System.out.println("\n--- SELESAI ---");
    }

    private static void displayAdtOperations() {
        System.out.println("ADT 'AntrianKafe' menyediakan operasi yang harus diimplementasikan:");
        System.out.println("1. tambahPelanggan(Customer customer)");
        System.out.println("2. hapusPelanggan()");
        System.out.println("3. tampilkanAntrian()");
        System.out.println("4. isEmpty()");
        System.out.println("5. getTotalAntrian()\n");
    }

    private static void demonstrateCustomer() {
        Customer customer = new Customer("Wildan", "081234567890", "Kopi Susu", "REGULAR");
        System.out.println("Contoh Customer: " + customer);
    }
}
