package model;

public class SingleLinkedList extends AntrianKafe {

    private static class Node {
        Pelanggan data;
        Node next;

        Node(Pelanggan data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    public SingleLinkedList() {
        super();
        this.head = null;
        this.tail = null;
    }

    @Override
    public void tambahPelanggan(Pelanggan pelanggan) {
        if (pelanggan == null) {
            return;
        }

        Node newNode = new Node(pelanggan);
        if (apakahKosong()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        totalAntrian++;
        System.out.println("[+] Berhasil ditambahkan ke Antrian REGULER (Single Linked List): " + pelanggan);
    }

    @Override
    public void hapusPelanggan() {
        if (apakahKosong()) {
            System.out.println("[!] Antrian REGULER kosong! Tidak ada pelanggan yang dapat dilayani.");
            return;
        }

        Pelanggan pelangganDihapus = head.data;
        head = head.next;
        totalAntrian--;

        if (head == null) {
            tail = null;
        }

        System.out.println("[-] Melayani pelanggan (FIFO): " + pelangganDihapus);
    }

    @Override
    public void tampilkanAntrian() {
        System.out.println("=== DAFTAR ANTRIAN: REGULER (SINGLE LINKED LIST) ===");
        if (apakahKosong()) {
            System.out.println("[ Antrian saat ini kosong - Tidak ada pelanggan yang mengantre ]");
            System.out.println("Total Antrian: 0");
            return;
        }

        System.out.println("+-----+---------------+--------------------+----------------+------------------+");
        System.out.println("| No  | No. Antrian   | Nama Pelanggan     | No. HP         | Pesanan          |");
        System.out.println("+-----+---------------+--------------------+----------------+------------------+");
        Node current = head;
        int index = 1;
        while (current != null) {
            Pelanggan p = current.data;
            String nama = formatKolom(p.getNama(), 18);
            String noHp = formatKolom(p.getNoHp(), 14);
            String pesanan = formatKolom(p.getPesanan(), 16);
            System.out.printf("| %-3d | %-13s | %-18s | %-14s | %-16s |\n",
                    index, p.getKodeAntrian(), nama, noHp, pesanan);
            current = current.next;
            index++;
        }
        System.out.println("+-----+---------------+--------------------+----------------+------------------+");
        System.out.println("Total Antrian: " + totalAntrian);
    }

    @Override
    public boolean apakahKosong() {
        return head == null;
    }
}
