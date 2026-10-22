package model;

// Antrian reguler pakai Single Linked List (SLL)
public class SingleLinkedList extends AntrianKafe {

    // Node pembungkus data pelanggan
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

    @Override
    public void tambahPelanggan(Pelanggan pelanggan) {
        if (pelanggan == null) return;

        Node newNode = new Node(pelanggan);
        if (apakahKosong()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        totalAntrian++;
        System.out.println("[+] Masuk antrian REGULER : " + pelanggan);
    }

    @Override
    public void hapusPelanggan() {
        if (apakahKosong()) {
            System.out.println("[!] Antrian REGULER kosong, tidak ada pelanggan untuk dilayani.");
            return;
        }

        Pelanggan dilayani = head.data;
        head = head.next; // geser head ke orang berikutnya
        totalAntrian--;

        // kalau antrian jadi habis, tail dinull-kan juga
        if (head == null) {
            tail = null;
        }
        System.out.println("[-] Melayani pelanggan (FIFO): " + dilayani);
    }

    @Override
    public void tampilkanAntrian() {
        System.out.println("=== DAFTAR ANTRIAN: REGULER (Single Linked List) ===");
        if (apakahKosong()) {
            System.out.println("[ Antrian kosong ]");
            System.out.println("Total: 0 orang");
            return;
        }

        Node current = head;
        int no = 1;
        while (current != null) {
            System.out.println(no + ". " + current.data);
            current = current.next;
            no++;
        }
        System.out.println("Total Antrian: " + totalAntrian + " orang");
    }

    @Override
    public boolean apakahKosong() {
        return head == null;
    }
}
