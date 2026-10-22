package model;

// Antrian VIP pakai Double Linked List (punya pointer prev dan next)
public class DoubleLinkedList extends AntrianKafe {

    private static class Node {
        Pelanggan data;
        Node prev;
        Node next;

        Node(Pelanggan data) {
            this.data = data;
            this.prev = null;
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
            newNode.prev = tail;
            tail = newNode;
        }
        totalAntrian++;
        System.out.println("[+] Masuk antrian VIP     : " + pelanggan);
    }

    @Override
    public void hapusPelanggan() {
        if (apakahKosong()) {
            System.out.println("[!] Antrian VIP kosong, tidak ada pelanggan untuk dilayani.");
            return;
        }

        Pelanggan dilayani = head.data;
        head = head.next;
        totalAntrian--;

        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
        System.out.println("[-] Melayani pelanggan (FIFO): " + dilayani);
    }

    @Override
    public void tampilkanAntrian() {
        System.out.println("=== DAFTAR ANTRIAN: VIP (Double Linked List) ===");
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

    // Traversal mundur dari belakang memanfaatkan pointer prev
    public void tampilkanAntrianDariBelakang() {
        System.out.println("=== DAFTAR ANTRIAN: VIP (Traversal Mundur dari Belakang) ===");
        if (apakahKosong()) {
            System.out.println("[ Antrian kosong ]");
            System.out.println("Total: 0 orang");
            return;
        }

        Node current = tail;
        int no = totalAntrian;
        while (current != null) {
            System.out.println(no + ". " + current.data);
            current = current.prev;
            no--;
        }
        System.out.println("Total Antrian: " + totalAntrian + " orang");
    }

    @Override
    public boolean apakahKosong() {
        return head == null;
    }
}
