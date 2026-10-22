package model;

/**
 * Antrian TAKEAWAY menggunakan Circular Linked List.
 * Pointer tail.next selalu menunjuk ke node head.
 */
public class CircularLinkedList extends AntrianKafe {

    private static class Node {
        Pelanggan data;
        Node next;

        Node(Pelanggan data) {
            this.data = data;
        }
    }

    private Node tail;

    public CircularLinkedList() {
        super();
        this.tail = null;
    }

    @Override
    public void tambahPelanggan(Pelanggan pelanggan) {
        if (pelanggan == null) {
            return;
        }

        Node newNode = new Node(pelanggan);

        if (tail == null) {
            newNode.next = newNode;
            tail = newNode;
        } else {
            newNode.next = tail.next; // newNode -> head
            tail.next = newNode;      // tail lama -> newNode
            tail = newNode;           // newNode jadi tail
        }
        totalAntrian++;
        System.out.println("[+] Berhasil ditambahkan ke Antrian TAKEAWAY (Circular Linked List): " + pelanggan);
    }

    @Override
    public void hapusPelanggan() {
        if (apakahKosong()) {
            System.out.println("[!] Antrian TAKEAWAY kosong! Tidak ada pelanggan yang dapat dilayani.");
            return;
        }

        Node head = tail.next;
        if (head == tail) {
            tail = null;
        } else {
            tail.next = head.next;
        }
        totalAntrian--;
        System.out.println("[-] Melayani pelanggan (FIFO): " + head.data);
    }

    @Override
    public void tampilkanAntrian() {
        System.out.println("=== DAFTAR ANTRIAN: TAKEAWAY (CIRCULAR LINKED LIST) ===");
        if (apakahKosong()) {
            System.out.println("[ Antrian saat ini kosong - Tidak ada pelanggan yang mengantre ]");
            System.out.println("Total Antrian: 0");
            return;
        }

        System.out.println("+-----+---------------+--------------------+----------------+------------------+");
        System.out.println("| No  | No. Antrian   | Nama Pelanggan     | No. HP         | Pesanan          |");
        System.out.println("+-----+---------------+--------------------+----------------+------------------+");
        Node current = tail.next; // mulai dari head
        int index = 1;
        do {
            Pelanggan p = current.data;
            String nama = formatKolom(p.getNama(), 18);
            String noHp = formatKolom(p.getNoHp(), 14);
            String pesanan = formatKolom(p.getPesanan(), 16);
            System.out.printf("| %-3d | %-13s | %-18s | %-14s | %-16s |\n",
                    index, p.getKodeAntrian(), nama, noHp, pesanan);
            current = current.next;
            index++;
        } while (current != tail.next);
        System.out.println("+-----+---------------+--------------------+----------------+------------------+");
        System.out.println("Total Antrian: " + totalAntrian);
    }

    @Override
    public boolean apakahKosong() {
        return tail == null;
    }
}
