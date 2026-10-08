package main;

import model.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEM ANTRIAN KAFE ===\n");

        AntrianKafe regular = new SingleLinkedList();
        AntrianKafe vip = new DoubleLinkedList();
        AntrianKafe takeaway = new CircularLinkedList();

        System.out.println("--- REGULAR (Single Linked List) ---");
        regular.tambahPelanggan(new Customer("Budi", "0812", "Kopi", "REGULAR"));
        regular.tambahPelanggan(new Customer("Ani", "0823", "Teh", "REGULAR"));
        regular.tampilkanAntrian();

        System.out.println("\n--- VIP (Double Linked List) ---");
        vip.tambahPelanggan(new Customer("Dewi", "0845", "Latte", "VIP"));
        vip.tambahPelanggan(new Customer("Eko", "0856", "Espresso", "VIP"));
        vip.tampilkanAntrian();

        System.out.println("\n--- TAKEAWAY (Circular Linked List) ---");
        takeaway.tambahPelanggan(new Customer("Fajar", "0867", "Sandwich", "TAKEAWAY"));
        takeaway.tambahPelanggan(new Customer("Gita", "0878", "Croissant", "TAKEAWAY"));
        takeaway.tampilkanAntrian();

        System.out.println("\n--- Test Hapus Pelanggan ---");
        System.out.println("Hapus dari REGULAR:");
        regular.hapusPelanggan();
        regular.tampilkanAntrian();
    }
}
