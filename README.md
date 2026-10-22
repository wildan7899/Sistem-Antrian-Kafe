# Sistem Antrian Kafe

Program Sistem Antrian Kafe dibuat menggunakan bahasa pemrograman **Java**. Proyek ini mengimplementasikan konsep:
1. **ADT (Abstract Data Type)** – kelas abstrak `AntrianKafe` sebagai kontrak antarmuka operasi antrian.
2. **Inheritance & Polymorphism** – `SingleLinkedList`, `DoubleLinkedList`, dan `CircularLinkedList` mewarisi kelas `AntrianKafe`.
3. **Struktur Data Linked List**:
   - **Single Linked List** untuk antrian reguler.
   - **Double Linked List** untuk antrian VIP (mendukung traversal maju dan mundur).
   - **Circular Linked List** untuk antrian takeaway (pointer `tail.next` menunjuk kembali ke `head`).

## Prasyarat
- Java Development Kit (JDK) versi 8 atau yang lebih baru.

## Struktur Proyek
```
Sistem-Antrian-Kafe/
├── src/
│   ├── model/                     # Logika data dan struktur linked list
│   │   ├── Pelanggan.java         # Entitas data pelanggan & generator nomor antrian
│   │   ├── AntrianKafe.java       # Kelas abstrak basis (ADT Antrian)
│   │   ├── SingleLinkedList.java   # Antrian Reguler (nested Node, pointer head & tail)
│   │   ├── DoubleLinkedList.java   # Antrian VIP (nested Node, pointer head, tail, prev, next)
│   │   └── CircularLinkedList.java # Antrian Takeaway (nested Node, pointer tail)
│   └── main/                      # Entry point eksekusi program
│       └── Main.java              # Program utama / simulasi antrian
├── bin/                           # Direktori output bytecode (.class)
├── .gitignore
└── README.md
```

## Kompilasi & Menjalankan Program

Buka terminal pada direktori root proyek (`Sistem-Antrian-Kafe`):

```bash
# 1. Kompilasi seluruh file sumber Java ke direktori bin
javac -d bin src/model/*.java src/main/*.java

# 2. Jalankan Program:
# Mode A: Menu Interaktif Kasir (Input pengguna)
java -cp bin main.Main

# Mode B: Demonstrasi Simulasi Otomatis Langsung
java -cp bin main.Main --demo
```

### Hasil Output Terminal (Simulasi Otomatis / Menu [5]):
```text
========================================
     DEMONSTRASI SIMULASI OTOMATIS
========================================

>>> TAHAP 1: Menambah Pelanggan Awal
[*] Memuat data awal antrian:
[+] Masuk antrian REGULER : [REGULER-001] Wildan | HP: 081234567890 | Pesanan: Kopi
[+] Masuk antrian REGULER : [REGULER-002] Bintang | HP: 081234567891 | Pesanan: Susu
[+] Masuk antrian VIP     : [VIP-100] Isam | HP: 081234567892 | Pesanan: Latte
[+] Masuk antrian TAKEAWAY: [TAKEAWAY-200] Topan | HP: 081234567893 | Pesanan: Sandwich

>>> TAHAP 2: Kondisi Antrian Saat Ini
=== DAFTAR ANTRIAN: REGULER (Single Linked List) ===
1. [REGULER-001] Wildan | HP: 081234567890 | Pesanan: Kopi
2. [REGULER-002] Bintang | HP: 081234567891 | Pesanan: Susu
Total Antrian: 2 orang

=== DAFTAR ANTRIAN: VIP (Double Linked List) ===
1. [VIP-100] Isam | HP: 081234567892 | Pesanan: Latte
Total Antrian: 1 orang

=== DAFTAR ANTRIAN: TAKEAWAY (Circular Linked List) ===
1. [TAKEAWAY-200] Topan | HP: 081234567893 | Pesanan: Sandwich
Total Antrian: 1 orang

>>> TAHAP 3: Melayani Pelanggan Terdepan (FIFO)
[-] Melayani pelanggan (FIFO): [REGULER-001] Wildan | HP: 081234567890 | Pesanan: Kopi
[-] Melayani pelanggan (FIFO): [VIP-100] Isam | HP: 081234567892 | Pesanan: Latte
[-] Melayani pelanggan (FIFO): [TAKEAWAY-200] Topan | HP: 081234567893 | Pesanan: Sandwich

>>> TAHAP 4: Kondisi Antrian Setelah Dilayani
=== DAFTAR ANTRIAN: REGULER (Single Linked List) ===
1. [REGULER-002] Bintang | HP: 081234567891 | Pesanan: Susu
Total Antrian: 1 orang

=== DAFTAR ANTRIAN: VIP (Double Linked List) ===
[ Antrian kosong ]
Total: 0 orang

=== DAFTAR ANTRIAN: TAKEAWAY (Circular Linked List) ===
[ Antrian kosong ]
Total: 0 orang

========================================
       SIMULASI OTOMATIS SELESAI
========================================
```

## Fitur & Operasi
1. **Penomoran Otomatis Berdasarkan Kategori**:
   - `REGULER-001`, `REGULER-002`, ...
   - `VIP-100`, `VIP-101`, ...
   - `TAKEAWAY-200`, `TAKEAWAY-201`, ...
2. **Operasi Standar ADT Antrian**:
   - `tambahPelanggan(Pelanggan)`: Menambahkan data pelanggan ke ujung belakang antrian.
   - `hapusPelanggan()`: Melayani dan mengeluarkan pelanggan terdepan antrian (FIFO).
   - `tampilkanAntrian()`: Menampilkan daftar seluruh pelanggan yang sedang mengantre.
   - `apakahKosong()`: Memeriksa apakah antrian dalam kondisi kosong.
   - `getTotalAntrian()`: Mengambil jumlah total pelanggan aktif dalam antrian.
3. **Getter Standar Entitas Pelanggan**:
   - `getKodeAntrian()`, `getNama()`, `getNoHp()`, `getPesanan()`, `getTipeAntrian()`.
4. **Pemisahan Paket Berorientasi Objek**:
   - Paket `model`: Berisi struktur data murni dan entitas data tanpa ketergantungan antarmuka luar.
   - Paket `main`: Berisi kelas `Main` sebagai runner pengujian dan demonstrasi simulasi antrian.

## Lisensi
Proyek Algoritma dan Struktur Data / PBO (2026).
