package model;

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

    public DoubleLinkedList() {
        super();
        this.head = null;
        this.tail = null;
    }

    @Override
    public void tambahPelanggan(Pelanggan pelanggan) {
        Node newNode = new Node(pelanggan);
        if (apakahKosong()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        totalAntrian++;
        System.out.println("Pelanggan berhasil ditambahkan ke Double Linked List: " + pelanggan);
    }

    @Override
    public void hapusPelanggan() {
        if (apakahKosong()) {
            System.out.println("Antrian kosong! Tidak ada pelanggan yang dapat dihapus.");
            return;
        }

        Pelanggan pelangganDihapus = head.data;
        head = head.next;
        totalAntrian--;

        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }

        System.out.println("Melayani / Menghapus pelanggan (FIFO): " + pelangganDihapus);
    }

    @Override
    public void tampilkanAntrian() {
        if (apakahKosong()) {
            System.out.println("Antrian kafe saat ini kosong.");
            return;
        }

        System.out.println("=== DAFTAR ANTRIAN KAFE (DOUBLE LINKED LIST) ===");
        Node current = head;
        int index = 1;
        while (current != null) {
            System.out.println(index + ". " + current.data);
            current = current.next;
            index++;
        }
        System.out.println("Total Antrian: " + totalAntrian);
    }

    @Override
    public boolean apakahKosong() {
        return head == null;
    }

    public void tampilkanAntrianDariBelakang() {
        if (apakahKosong()) {
            System.out.println("Antrian kafe saat ini kosong.");
            return;
        }

        System.out.println("=== DAFTAR ANTRIAN KAFE (DARI BELAKANG) ===");
        Node current = tail;
        int index = totalAntrian;
        while (current != null) {
            System.out.println(index + ". " + current.data);
            current = current.prev;
            index--;
        }
    }
}
