package main;

import model.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEM ANTRIAN KAFE ===\n");

        // Instansiasi antrian menggunakan implementasi linked list
        AntrianKafe antrianReguler = new SingleLinkedList();
        AntrianKafe antrianVIP = new DoubleLinkedList();
        AntrianKafe antrianTakeaway = new CircularLinkedList();

        System.out.println("--- 1. MENAMBAH PELANGGAN KE ANTRIAN ---");
        // Reguler (Single Linked List)
        antrianReguler.tambahPelanggan(new Pelanggan("Wildan", "081234567890", "Kopi", "REGULER"));
        antrianReguler.tambahPelanggan(new Pelanggan("Bintang", "081234567891", "Susu", "REGULER"));

        // VIP (Double Linked List)
        antrianVIP.tambahPelanggan(new Pelanggan("Isam", "081234567892", "Latte", "VIP"));

        // Takeaway (Circular Linked List)
        antrianTakeaway.tambahPelanggan(new Pelanggan("Topan", "081234567893", "Sandwich", "TAKEAWAY"));

        System.out.println("\n--- 2. STATUS ANTRIAN SAAT INI ---");
        antrianReguler.tampilkanAntrian();
        System.out.println();
        antrianVIP.tampilkanAntrian();
        System.out.println();
        antrianTakeaway.tampilkanAntrian();

        System.out.println("\n--- 3. MELAYANI PELANGGAN (FIFO) ---");
        antrianReguler.hapusPelanggan();
        antrianVIP.hapusPelanggan();
        antrianTakeaway.hapusPelanggan();

        System.out.println("\n--- 4. STATUS ANTRIAN SETELAH DILAYANI ---");
        antrianReguler.tampilkanAntrian();
        System.out.println();
        antrianVIP.tampilkanAntrian();
        System.out.println();
        antrianTakeaway.tampilkanAntrian();

        System.out.println("\n=== SELESAI ===");
    }
}
