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

# 2. Jalankan Program (Pilih salah satu mode):
# Mode A: Menu Interaktif Kasir (Input pengguna)
java -cp bin main.Main

# Mode B: Demonstrasi Simulasi Otomatis Langsung (Data tim lengkap)
java -cp bin main.Main --demo
```

### Hasil Output Terminal (Simulasi Otomatis / Menu [5]):
```text
================================================================================
                     SISTEM MANAJEMEN ANTRIAN KAFE                              
================================================================================

--------------------------------------------------------------------------------
>>> 1. MENAMBAH PELANGGAN KE ANTRIAN
--------------------------------------------------------------------------------
[+] Berhasil ditambahkan ke Antrian REGULER (Single Linked List): [REGULER-001] Wildan | HP: 081234567890 | Pesanan: Kopi
[+] Berhasil ditambahkan ke Antrian REGULER (Single Linked List): [REGULER-002] Bintang | HP: 081234567891 | Pesanan: Susu
[+] Berhasil ditambahkan ke Antrian VIP (Double Linked List): [VIP-100] Isam | HP: 081234567892 | Pesanan: Latte
[+] Berhasil ditambahkan ke Antrian TAKEAWAY (Circular Linked List): [TAKEAWAY-200] Topan | HP: 081234567893 | Pesanan: Sandwich

--------------------------------------------------------------------------------
>>> 2. STATUS SELURUH ANTRIAN SAAT INI
--------------------------------------------------------------------------------
=== DAFTAR ANTRIAN: REGULER (SINGLE LINKED LIST) ===
+-----+---------------+--------------------+----------------+------------------+
| No  | No. Antrian   | Nama Pelanggan     | No. HP         | Pesanan          |
+-----+---------------+--------------------+----------------+------------------+
| 1   | REGULER-001   | Wildan             | 081234567890   | Kopi             |
| 2   | REGULER-002   | Bintang            | 081234567891   | Susu             |
+-----+---------------+--------------------+----------------+------------------+
Total Antrian: 2

=== DAFTAR ANTRIAN: VIP (DOUBLE LINKED LIST) ===
+-----+---------------+--------------------+----------------+------------------+
| No  | No. Antrian   | Nama Pelanggan     | No. HP         | Pesanan          |
+-----+---------------+--------------------+----------------+------------------+
| 1   | VIP-100       | Isam               | 081234567892   | Latte            |
+-----+---------------+--------------------+----------------+------------------+
Total Antrian: 1

=== DAFTAR ANTRIAN: TAKEAWAY (CIRCULAR LINKED LIST) ===
+-----+---------------+--------------------+----------------+------------------+
| No  | No. Antrian   | Nama Pelanggan     | No. HP         | Pesanan          |
+-----+---------------+--------------------+----------------+------------------+
| 1   | TAKEAWAY-200  | Topan              | 081234567893   | Sandwich         |
+-----+---------------+--------------------+----------------+------------------+
Total Antrian: 1

--------------------------------------------------------------------------------
>>> 3. MELAYANI PELANGGAN (FIFO)
--------------------------------------------------------------------------------
[-] Melayani pelanggan (FIFO): [REGULER-001] Wildan | HP: 081234567890 | Pesanan: Kopi
[-] Melayani pelanggan (FIFO): [VIP-100] Isam | HP: 081234567892 | Pesanan: Latte
[-] Melayani pelanggan (FIFO): [TAKEAWAY-200] Topan | HP: 081234567893 | Pesanan: Sandwich

--------------------------------------------------------------------------------
>>> 4. STATUS ANTRIAN SETELAH DILAYANI
--------------------------------------------------------------------------------
=== DAFTAR ANTRIAN: REGULER (SINGLE LINKED LIST) ===
+-----+---------------+--------------------+----------------+------------------+
| No  | No. Antrian   | Nama Pelanggan     | No. HP         | Pesanan          |
+-----+---------------+--------------------+----------------+------------------+
| 1   | REGULER-002   | Bintang            | 081234567891   | Susu             |
+-----+---------------+--------------------+----------------+------------------+
Total Antrian: 1

=== DAFTAR ANTRIAN: VIP (DOUBLE LINKED LIST) ===
[ Antrian saat ini kosong - Tidak ada pelanggan yang mengantre ]
Total Antrian: 0

=== DAFTAR ANTRIAN: TAKEAWAY (CIRCULAR LINKED LIST) ===
[ Antrian saat ini kosong - Tidak ada pelanggan yang mengantre ]
Total Antrian: 0

================================================================================
                       SIMULASI PROGRAM SELESAI                                 
================================================================================
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
   - `apakahKosong()` / `isEmpty()`: Memeriksa apakah antrian dalam kondisi kosong.
   - `getTotalAntrian()`: Mengambil jumlah total pelanggan aktif dalam antrian.
3. **Getter Standar Entitas Pelanggan**:
   - `getNomorAntrian()`, `getNama()`, `getNoHp()`, `getPesanan()`, `getTipeAntrian()`.
4. **Pemisahan Paket Berorientasi Objek**:
   - Paket `model`: Berisi struktur data murni dan entitas data tanpa ketergantungan antarmuka luar.
   - Paket `main`: Berisi kelas `Main` sebagai runner pengujian dan demonstrasi simulasi antrian.

## Cara Berkontribusi
1. Lakukan *fork* pada repositori ini.
2. Buat *branch* fitur baru (`git checkout -b fitur/nama-fitur`).
3. Lakukan *commit* terhadap perubahan (`git commit -m 'Menambahkan fitur XYZ'`).
4. *Push* ke branch Anda (`git push origin fitur/nama-fitur`).
5. Buat *Pull Request*.

## Lisensi
Proyek Praktikum Algoritma dan Struktur Data (2026). Bebas digunakan untuk keperluan edukasi dan pembelajaran.
