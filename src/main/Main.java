package main;

import java.util.Scanner;
import model.*;

public class Main {

    // =========================================================================
    // IMPLEMENTASI INHERITANCE & POLYMORPHISM (Tim Inheritance)
    // Menggunakan tipe referensi superclass (AntrianKafe) untuk menginstansiasi
    // subclass konkret (SingleLinkedList, DoubleLinkedList, CircularLinkedList)
    // =========================================================================
    private static AntrianKafe antrianReguler = new SingleLinkedList();
    private static DoubleLinkedList antrianVIP = new DoubleLinkedList();
    private static AntrianKafe antrianTakeaway = new CircularLinkedList();

    public static void main(String[] args) {
        // Mendukung mode demo otomatis (misal: java -cp bin main.Main --demo)
        if (args.length > 0 && (args[0].equalsIgnoreCase("--demo") || args[0].equalsIgnoreCase("-d"))) {
            jalankanSimulasiOtomatis();
            return;
        }

        Scanner scanner = new Scanner(System.in);

        // Memuat data awal bawaan (WILDAN, BINTANG, ISAM, TOPAN)
        muatDataAwal();

        boolean berjalan = true;
        while (berjalan) {
            tampilkanMenuUtama();
            System.out.print("Pilih opsi menu (0-5): ");
            String pilihan = scanner.nextLine().trim();

            System.out.println();
            switch (pilihan) {
                case "1":
                    menuTambahPelanggan(scanner);
                    break;
                case "2":
                    menuLayaniPelanggan(scanner);
                    break;
                case "3":
                    menuTampilkanSemuaAntrian();
                    break;
                case "4":
                    menuTampilkanVIPMundur();
                    break;
                case "5":
                    jalankanSimulasiOtomatis();
                    break;
                case "0":
                    System.out.println("================================================================================");
                    System.out.println("          Terima kasih telah menggunakan Sistem Antrian Kafe!                   ");
                    System.out.println("================================================================================");
                    berjalan = false;
                    break;
                default:
                    System.out.println("[!] Pilihan tidak valid. Silakan masukkan angka antara 0 sampai 5.");
                    break;
            }

            if (berjalan) {
                System.out.print("\nTekan [ENTER] untuk kembali ke menu utama...");
                scanner.nextLine();
                System.out.println();
            }
        }

        scanner.close();
    }

    /**
     * Memuat data bawaan anggota tim ke dalam antrian saat program pertama kali dibuka.
     */
    private static void muatDataAwal() {
        System.out.println("================================================================================");
        System.out.println("                     SISTEM MANAJEMEN ANTRIAN KAFE                              ");
        System.out.println("================================================================================\n");
        System.out.println("[*] Memuat data awal pelanggan ke dalam sistem antrian...");

        Pelanggan.resetPenghitung();

        // Data Awal Tim (Wildan, Bintang, Isam, Topan)
        antrianReguler.tambahPelanggan(new Pelanggan("Wildan", "081234567890", "Kopi", "REGULER"));
        antrianReguler.tambahPelanggan(new Pelanggan("Bintang", "081234567891", "Susu", "REGULER"));
        antrianVIP.tambahPelanggan(new Pelanggan("Isam", "081234567892", "Latte", "VIP"));
        antrianTakeaway.tambahPelanggan(new Pelanggan("Topan", "081234567893", "Sandwich", "TAKEAWAY"));

        System.out.println("\n[v] Data antrian awal (Wildan, Bintang, Isam, Topan) berhasil dimuat!\n");
    }

    /**
     * Menampilkan daftar menu interaktif.
     */
    private static void tampilkanMenuUtama() {
        System.out.println("================================================================================");
        System.out.println("                             MENU UTAMA ANTRIAN KAFE                            ");
        System.out.println("================================================================================");
        System.out.println("[1] Tambah Pelanggan Baru ke Antrian");
        System.out.println("[2] Panggil / Layani Pelanggan (FIFO)");
        System.out.println("[3] Lihat Seluruh Antrian Aktif (Format Tabel Rapi)");
        System.out.println("[4] Lihat Antrian VIP Traversal dari Belakang (Fitur Double Linked List)");
        System.out.println("[5] Jalankan Demonstrasi Simulasi Otomatis (4 Tahap Lengkap)");
        System.out.println("[0] Keluar dari Sistem");
        System.out.println("--------------------------------------------------------------------------------");
    }

    /**
     * Menu input untuk menambahkan pelanggan baru.
     */
    private static void menuTambahPelanggan(Scanner scanner) {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(">>> FORM TAMBAH PELANGGAN BARU");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Pilih Kategori Antrian:");
        System.out.println("1. REGULER   (Single Linked List)");
        System.out.println("2. VIP       (Double Linked List)");
        System.out.println("3. TAKEAWAY  (Circular Linked List)");
        System.out.print("Pilih kategori (1-3): ");
        String katPilihan = scanner.nextLine().trim();

        String tipe;
        AntrianKafe targetAntrian;

        if (katPilihan.equals("1")) {
            tipe = "REGULER";
            targetAntrian = antrianReguler;
        } else if (katPilihan.equals("2")) {
            tipe = "VIP";
            targetAntrian = antrianVIP;
        } else if (katPilihan.equals("3")) {
            tipe = "TAKEAWAY";
            targetAntrian = antrianTakeaway;
        } else {
            System.out.println("[!] Kategori tidak valid. Pendaftaran pelanggan dibatalkan.");
            return;
        }

        System.out.print("Masukkan Nama Pelanggan : ");
        String nama = scanner.nextLine().trim();
        if (nama.isEmpty()) {
            System.out.println("[!] Nama tidak boleh kosong. Pendaftaran dibatalkan.");
            return;
        }

        System.out.print("Masukkan Nomor HP       : ");
        String noHp = scanner.nextLine().trim();
        if (noHp.isEmpty()) {
            noHp = "-";
        }

        System.out.print("Masukkan Pesanan        : ");
        String pesanan = scanner.nextLine().trim();
        if (pesanan.isEmpty()) {
            System.out.println("[!] Pesanan tidak boleh kosong. Pendaftaran dibatalkan.");
            return;
        }

        Pelanggan pBaru = new Pelanggan(nama, noHp, pesanan, tipe);
        targetAntrian.tambahPelanggan(pBaru);
        System.out.println("\n[v] Pelanggan berhasil didaftarkan dengan ID: " + pBaru.getKodeAntrian());
    }

    /**
     * Menu untuk melayani / menghapus pelanggan secara FIFO.
     */
    private static void menuLayaniPelanggan(Scanner scanner) {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(">>> PROSES PELAYANAN PELANGGAN (FIFO)");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Pilih Antrian yang Ingin Dilayani:");
        System.out.println("1. Layani Antrian REGULER");
        System.out.println("2. Layani Antrian VIP");
        System.out.println("3. Layani Antrian TAKEAWAY");
        System.out.println("4. Layani Satu Pelanggan dari Semua Antrian Sekaligus");
        System.out.print("Pilihan (1-4): ");
        String katPilihan = scanner.nextLine().trim();

        System.out.println();
        switch (katPilihan) {
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
                System.out.println("[*] Memproses pelanggan terdepan dari tiap kategori antrian:");
                antrianReguler.hapusPelanggan();
                antrianVIP.hapusPelanggan();
                antrianTakeaway.hapusPelanggan();
                break;
            default:
                System.out.println("[!] Pilihan kategori tidak valid.");
                break;
        }
    }

    /**
     * Menampilkan semua antrian dalam format tabel rapi.
     */
    private static void menuTampilkanSemuaAntrian() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(">>> STATUS SELURUH ANTRIAN KAFE SAAT INI");
        System.out.println("--------------------------------------------------------------------------------");
        antrianReguler.tampilkanAntrian();
        System.out.println();
        antrianVIP.tampilkanAntrian();
        System.out.println();
        antrianTakeaway.tampilkanAntrian();
    }

    /**
     * Menampilkan antrian VIP secara terbalik (traversal dari belakang menggunakan pointer prev).
     */
    private static void menuTampilkanVIPMundur() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(">>> TRAVERSAL ANTRIAN VIP DARI BELAKANG KE DEPAN");
        System.out.println("--------------------------------------------------------------------------------");
        antrianVIP.tampilkanAntrianDariBelakang();
    }

    /**
     * Menjalankan simulasi otomatis lengkap 4 tahap dengan data bawaan tim.
     */
    private static void jalankanSimulasiOtomatis() {
        System.out.println("================================================================================");
        System.out.println("               DEMONSTRASI SIMULASI OTOMATIS SISTEM ANTRIAN KAFE                ");
        System.out.println("================================================================================\n");

        int saveReg = Pelanggan.getPenghitungReguler();
        int saveVip = Pelanggan.getPenghitungVIP();
        int saveTak = Pelanggan.getPenghitungTakeaway();

        Pelanggan.resetPenghitung();

        AntrianKafe demoReguler = new SingleLinkedList();
        DoubleLinkedList demoVIP = new DoubleLinkedList();
        AntrianKafe demoTakeaway = new CircularLinkedList();

        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(">>> 1. MENAMBAH PELANGGAN KE ANTRIAN");
        System.out.println("--------------------------------------------------------------------------------");
        demoReguler.tambahPelanggan(new Pelanggan("Wildan", "081234567890", "Kopi", "REGULER"));
        demoReguler.tambahPelanggan(new Pelanggan("Bintang", "081234567891", "Susu", "REGULER"));
        demoVIP.tambahPelanggan(new Pelanggan("Isam", "081234567892", "Latte", "VIP"));
        demoTakeaway.tambahPelanggan(new Pelanggan("Topan", "081234567893", "Sandwich", "TAKEAWAY"));

        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println(">>> 2. STATUS SELURUH ANTRIAN SAAT INI");
        System.out.println("--------------------------------------------------------------------------------");
        demoReguler.tampilkanAntrian();
        System.out.println();
        demoVIP.tampilkanAntrian();
        System.out.println();
        demoTakeaway.tampilkanAntrian();

        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println(">>> 3. MELAYANI PELANGGAN (FIFO)");
        System.out.println("--------------------------------------------------------------------------------");
        demoReguler.hapusPelanggan();
        demoVIP.hapusPelanggan();
        demoTakeaway.hapusPelanggan();

        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println(">>> 4. STATUS ANTRIAN SETELAH DILAYANI");
        System.out.println("--------------------------------------------------------------------------------");
        demoReguler.tampilkanAntrian();
        System.out.println();
        demoVIP.tampilkanAntrian();
        System.out.println();
        demoTakeaway.tampilkanAntrian();

        System.out.println("\n================================================================================");
        System.out.println("                       SIMULASI PROGRAM SELESAI                                 ");
        System.out.println("================================================================================");

        // Mengembalikan nilai counter antrian untuk mode interaktif yang sedang berjalan
        Pelanggan.setPenghitung(saveReg, saveVip, saveTak);
    }
}
