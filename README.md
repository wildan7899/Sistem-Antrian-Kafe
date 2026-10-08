# Sistem Antrian Kafe

Program Sistem Antrian Kafe dibuat menggunakan bahasa **Java**. Proyek ini mengimplementasikan konsep:
1. **ADT (Abstract Data Type)** – class `AntrianKafe` abstrak sebagai kontrak antrian.
2. **Inheritance** – `SingleLinkedList`, `DoubleLinkedList`, `CircularLinkedList` mewarisi `AntrianKafe`.
3. **Linked List** – tiga jenis: single (antrian regular), double (antrian VIP), circular (antrian takeaway).

## Struktur Project
```
src/
├── model/                 # Semua model data
│   ├── Customer.java      # Data pelanggan + auto-numbering
│   ├── Node.java          # Node generik untuk linked list
│   ├── AntrianKafe.java   # ADT antrian kafe
│   ├── SingleLinkedList.java
│   ├── DoubleLinkedList.java
│   └── CircularLinkedList.java
└── main/                  # Program utama dan antarmuka
    ├── Main.java          # Entry point
    └── Menu.java          # Menu dan interaksi (jika dikembangkan)
bin/                       # Output class files (ignore)
.gitignore
README.md
```

## Compile & Run
```bash
# Compile semua file
javac -d bin src/model/*.java src/main/*.java

# Jalankan program
java -cp bin main.Main

# Hasil output contoh:
=== SISTEM ANTRIAN KAFE ===
Status Antrian Awal:
--- REGULAR ---
[REGULAR-001] Budi            | HP: 0812         | Pesanan: Kopi
--- VIP ---
[VIP-100] Dewi            | HP: 0845         | Pesanan: Latte
--- TAKEAWAY ---
[TAKEAWAY-200] Fajar           | HP: 0867         | Pesanan: Sandwich
```

## Fitur
 1. Auto‑numbering antrian per tipe (REGULAR‑001, VIP‑100, TAKEAWAY‑200).
 2. Implementasi ADT dengan method `tambahPelanggan`, `hapusPelanggan`, `tampilkanAntrian`, `isEmpty`.
 3. Inheritance untuk tiga tipe antrian:
    - Regular → Single Linked List
    - VIP → Double Linked List  
    - Takeaway → Circular Linked List
 4. Struktur package (`model`, `main`) memisahkan logika dan UI.

## Cara Berkontribusi
 1. Fork repository.
 2. Buat branch baru (`feature/xxx`).
 3. Commit perubahan.
 4. Push ke branch dan buat Pull Request.

## Lisensi
Proyek praktikum Algoritma dan Pemrograman (2026). Bebas untuk penggunaan edukasi.
