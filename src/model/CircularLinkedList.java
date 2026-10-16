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
        System.out.println("Pelanggan berhasil ditambahkan ke Circular Linked List: " + pelanggan);
    }

    @Override
    public void hapusPelanggan() {
        if (apakahKosong()) {
            System.out.println("Antrian kosong! Tidak ada pelanggan yang dapat dihapus.");
            return;
        }

        Node head = tail.next;
        if (head == tail) {
            tail = null;
        } else {
            tail.next = head.next;
        }
        totalAntrian--;
        System.out.println("Melayani / Menghapus pelanggan (FIFO): " + head.data);
    }

    @Override
    public void tampilkanAntrian() {
        if (apakahKosong()) {
            System.out.println("Antrian kafe saat ini kosong.");
            return;
        }

        System.out.println("=== DAFTAR ANTRIAN KAFE (CIRCULAR LINKED LIST) ===");
        Node current = tail.next; // mulai dari head
        int index = 1;
        do {
            System.out.println(index + ". " + current.data);
            current = current.next;
            index++;
        } while (current != tail.next);
        System.out.println("Total Antrian: " + totalAntrian);
    }

    @Override
    public boolean apakahKosong() {
        return tail == null;
    }
}
