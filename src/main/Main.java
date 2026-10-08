package main;

import model.*;

/**
 * Program demo untuk menunjukkan penggunaan ADT AntrianKafe
 * Catatan: Implementasi konkret akan dibuat oleh tim lain (Inheritance & Linked List)
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== DEMO ADT ANTRIAN KAFE ===\n");
        
        // ADT murni hanya berupa kontrak, implementasi konkret nanti dibuat teman lain
        // Untuk demo, kita hanya menunjukkan struktur ADT yang telah dibuat
        System.out.println("ADT 'AntrianKafe' memiliki 5 operasi abstrak:");
        System.out.println("1. tambahPelanggan(Customer c)");
        System.out.println("2. hapusPelanggan()");
        System.out.println("3. tampilkanAntrian()");
        System.out.println("4. isEmpty()");
        System.out.println("5. getTotalAntrian()\n");
        
        System.out.println("Customer ADT juga sudah siap:");
        Customer dummy = new Customer("Wildan", "081234567890", "Kopi Susu", "REGULAR");
        System.out.println("Customer: " + dummy);
        
        System.out.println("\n--- END OF DEMO ---");
        System.out.println("Tim inheritance akan implement Single/Double/Circular LinkedList");
        System.out.println("Tim linked list akan implement Node dan struktur linked list");
    }
}
