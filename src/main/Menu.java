package main;

import model.*;
import java.util.Scanner;

public class Menu {
    private AntrianKafe regular = new SingleLinkedList();
    private AntrianKafe vip = new DoubleLinkedList();
    private AntrianKafe takeaway = new CircularLinkedList();
    private Scanner scanner = new Scanner(System.in);

    public void jalankan() {
        // Data Dummy awal
        regular.tambahPelanggan(new Customer("Budi", "0812", "Kopi", "REGULAR"));
        vip.tambahPelanggan(new Customer("Dewi", "0845", "Latte", "VIP"));
        takeaway.tambahPelanggan(new Customer("Fajar", "0867", "Sandwich", "TAKEAWAY"));

        System.out.println("=== SISTEM ANTRIAN KAFE ===");
        System.out.println("Status Antrian Awal:");
        tampilkanSemua();
    }

    private void tampilkanSemua() {
        System.out.println("\n--- REGULAR ---");
        regular.tampilkanAntrian();
        System.out.println("\n--- VIP ---");
        vip.tampilkanAntrian();
        System.out.println("\n--- TAKEAWAY ---");
        takeaway.tampilkanAntrian();
    }
}
