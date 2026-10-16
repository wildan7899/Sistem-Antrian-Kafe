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

# 2. Jalankan kelas utama
java -cp bin main.Main
```

### Hasil Output Terminal:
```text
=== SISTEM ANTRIAN KAFE ===

--- 1. MENAMBAH PELANGGAN KE ANTRIAN ---
Pelanggan berhasil ditambahkan ke Single Linked List: [REGULER-001] Wildan | HP: 081234567890 | Pesanan: Kopi
Pelanggan berhasil ditambahkan ke Single Linked List: [REGULER-002] Bintang | HP: 081234567891 | Pesanan: Susu
Pelanggan berhasil ditambahkan ke Double Linked List: [VIP-100] Isam | HP: 081234567892 | Pesanan: Latte
Pelanggan berhasil ditambahkan ke Circular Linked List: [TAKEAWAY-200] Topan | HP: 081234567893 | Pesanan: Sandwich

--- 2. STATUS ANTRIAN SAAT INI ---
=== DAFTAR ANTRIAN KAFE (SINGLE LINKED LIST) ===
1. [REGULER-001] Wildan | HP: 081234567890 | Pesanan: Kopi
2. [REGULER-002] Bintang | HP: 081234567891 | Pesanan: Susu
Total Antrian: 2

=== DAFTAR ANTRIAN KAFE (DOUBLE LINKED LIST) ===
1. [VIP-100] Isam | HP: 081234567892 | Pesanan: Latte
Total Antrian: 1

=== DAFTAR ANTRIAN KAFE (CIRCULAR LINKED LIST) ===
1. [TAKEAWAY-200] Topan | HP: 081234567893 | Pesanan: Sandwich
Total Antrian: 1

--- 3. MELAYANI PELANGGAN (FIFO) ---
Melayani / Menghapus pelanggan (FIFO): [REGULER-001] Wildan | HP: 081234567890 | Pesanan: Kopi
Melayani / Menghapus pelanggan (FIFO): [VIP-100] Isam | HP: 081234567892 | Pesanan: Latte
Melayani / Menghapus pelanggan (FIFO): [TAKEAWAY-200] Topan | HP: 081234567893 | Pesanan: Sandwich

--- 4. STATUS ANTRIAN SETELAH DILAYANI ---
=== DAFTAR ANTRIAN KAFE (SINGLE LINKED LIST) ===
1. [REGULER-002] Bintang | HP: 081234567891 | Pesanan: Susu
Total Antrian: 1

Antrian kafe saat ini kosong.

Antrian kafe saat ini kosong.

=== SELESAI ===
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
