package main;

import java.util.Scanner;
import model.*;

public class Main {

    // Penerapan polimorfisme: referensi class induk buat nampung objek class anak
    private static AntrianKafe antrianReguler = new SingleLinkedList();
    private static DoubleLinkedList antrianVIP = new DoubleLinkedList();
    private static AntrianKafe antrianTakeaway = new CircularLinkedList();

    public static void main(String[] args) {
        // Buat cek demo langsung kalau pake argumen --demo
        if (args.length > 0 && args[0].equalsIgnoreCase("--demo")) {
            jalankanDemo();
            return;
        }

        Scanner scanner = new Scanner(System.in);
        clearScreen();
        muatDataAwal();

        boolean running = true;
        while (running) {
            System.out.println("\n========================================");
            System.out.println("       SISTEM ANTRIAN KAFE");
            System.out.println("========================================");
            System.out.println("1. Tambah Pelanggan ke Antrian");
            System.out.println("2. Layani Pelanggan (FIFO)");
            System.out.println("3. Tampilkan Semua Antrian");
            System.out.println("4. Tampilkan Antrian VIP dari Belakang (Fitur DLL)");
            System.out.println("5. Jalankan Simulasi Otomatis (Demo Tim)");
            System.out.println("0. Keluar");
            System.out.println("----------------------------------------");
            System.out.print("Pilih menu (0-5): ");

            String input = scanner.nextLine().trim();
            System.out.println();

            switch (input) {
                case "1":
                    menuTambah(scanner);
                    break;
                case "2":
                    menuLayani(scanner);
                    break;
                case "3":
                    tampilkanSemua();
                    break;
                case "4":
                    antrianVIP.tampilkanAntrianDariBelakang();
                    break;
                case "5":
                    jalankanDemo();
                    break;
                case "0":
                    System.out.println("Terima kasih. Program selesai.");
                    running = false;
                    break;
                default:
                    System.out.println("[!] Pilihan tidak valid.");
            }

            if (running) {
                System.out.print("\nTekan [ENTER] untuk kembali ke menu...");
                scanner.nextLine();
                clearScreen();
            }
        }

        scanner.close();
    }

    // Fungsi bersihin layar konsol
    private static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            for (int i = 0; i < 30; i++) {
                System.out.println();
            }
        }
    }

    // Isi data awal pelanggan untuk simulasi
    private static void muatDataAwal() {
        Pelanggan.resetPenghitung();
        antrianReguler = new SingleLinkedList();
        antrianVIP = new DoubleLinkedList();
        antrianTakeaway = new CircularLinkedList();

        System.out.println("[*] Memuat data awal antrian:");
        antrianReguler.tambahPelanggan(new Pelanggan("Wildan", "081234567890", "Kopi", "REGULER"));
        antrianReguler.tambahPelanggan(new Pelanggan("Bintang", "081234567891", "Susu", "REGULER"));
        antrianVIP.tambahPelanggan(new Pelanggan("Isam", "081234567892", "Latte", "VIP"));
        antrianTakeaway.tambahPelanggan(new Pelanggan("Topan", "081234567893", "Sandwich", "TAKEAWAY"));
    }

    // Input pelanggan baru lewat konsol
    private static void menuTambah(Scanner scanner) {
        System.out.println("--- TAMBAH PELANGGAN BARU ---");
        System.out.println("Kategori: 1. Reguler | 2. VIP | 3. Takeaway");
        System.out.print("Pilih kategori (1-3): ");
        String kat = scanner.nextLine().trim();

        AntrianKafe antrianTujuan;
        String tipe;

        if (kat.equals("1")) {
            antrianTujuan = antrianReguler;
            tipe = "REGULER";
        } else if (kat.equals("2")) {
            antrianTujuan = antrianVIP;
            tipe = "VIP";
        } else if (kat.equals("3")) {
            antrianTujuan = antrianTakeaway;
            tipe = "TAKEAWAY";
        } else {
            System.out.println("[!] Kategori tidak valid.");
            return;
        }

        System.out.print("Nama     : ");
        String nama = scanner.nextLine().trim();
        System.out.print("No. HP   : ");
        String hp = scanner.nextLine().trim();
        System.out.print("Pesanan  : ");
        String pesanan = scanner.nextLine().trim();

        if (nama.isEmpty() || pesanan.isEmpty()) {
            System.out.println("[!] Nama dan pesanan wajib diisi.");
            return;
        }

        Pelanggan baru = new Pelanggan(nama, hp, pesanan, tipe);
        antrianTujuan.tambahPelanggan(baru);
    }

    // Layani antrian yang ada di paling depan (FIFO)
    private static void menuLayani(Scanner scanner) {
        System.out.println("--- LAYANI PELANGGAN (FIFO) ---");
        System.out.println("1. Reguler | 2. VIP | 3. Takeaway | 4. Layani Semua Sekaligus");
        System.out.print("Pilih kategori (1-4): ");
        String pilihan = scanner.nextLine().trim();

        System.out.println();
        switch (pilihan) {
            case "1":
                antrianReguler.hapusPelanggan();
                break;
            case "2":
                antrianVIP.hapusPelanggan();
                break;
            case "3":
                antrianTakeaway.hapusPelanggan();
                break;
            case "4":
                antrianReguler.hapusPelanggan();
                antrianVIP.hapusPelanggan();
                antrianTakeaway.hapusPelanggan();
                break;
            default:
                System.out.println("[!] Pilihan tidak valid.");
        }
    }

    private static void tampilkanSemua() {
        antrianReguler.tampilkanAntrian();
        System.out.println();
        antrianVIP.tampilkanAntrian();
        System.out.println();
        antrianTakeaway.tampilkanAntrian();
    }

    // Demo otomatis buat ngetes alur antrian dari awal sampai habis
    private static void jalankanDemo() {
        clearScreen();
        System.out.println("========================================");
        System.out.println("     DEMONSTRASI SIMULASI OTOMATIS");
        System.out.println("========================================");

        System.out.println("\n>>> TAHAP 1: Menambah Pelanggan Awal");
        muatDataAwal();

        System.out.println("\n>>> TAHAP 2: Kondisi Antrian Saat Ini");
        tampilkanSemua();

        System.out.println("\n>>> TAHAP 3: Melayani Pelanggan Terdepan (FIFO)");
        antrianReguler.hapusPelanggan();
        antrianVIP.hapusPelanggan();
        antrianTakeaway.hapusPelanggan();

        System.out.println("\n>>> TAHAP 4: Kondisi Antrian Setelah Dilayani");
        tampilkanSemua();

        System.out.println("\n========================================");
        System.out.println("       SIMULASI OTOMATIS SELESAI");
        System.out.println("========================================");
    }
}
