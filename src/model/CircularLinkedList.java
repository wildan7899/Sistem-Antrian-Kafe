package model;

/**
 * Antrian TAKEAWAY menggunakan Circular Linked List (singly).
 * Menyimpan pointer ke node TERAKHIR (tail); tail.next selalu menunjuk
 * ke node pertama (head), sehingga tambah di belakang dan hapus di depan
 * sama-sama O(1).
 */
public class CircularLinkedList extends AntrianKafe {

    // Node dibuat nested supaya file ini tidak bergantung pada Node.java
    private static class Node {
        Customer data;
        Node next;

        Node(Customer data) {
            this.data = data;
        }
    }

    private Node tail;

    public CircularLinkedList() {
        super();
        this.tail = null;
    }

    // Tambah pelanggan di belakang antrian
    @Override
    public void tambahPelanggan(Customer customer) {
        if (customer == null) {
            return;
        }

        Node baru = new Node(customer);

        if (tail == null) {
            // Node pertama menunjuk ke dirinya sendiri
            baru.next = baru;
            tail = baru;
        } else {
            baru.next = tail.next; // baru -> head
            tail.next = baru;      // tail lama -> baru
            tail = baru;           // baru jadi tail
        }
        totalAntrian++;
    }

    // Hapus pelanggan paling depan (FIFO)
    @Override
    public void hapusPelanggan() {
        if (isEmpty()) {
            System.out.println("Antrian TAKEAWAY kosong.");
            return;
        }

        Node head = tail.next;
        System.out.println("Melayani: " + head.data);

        if (head == tail) {
            // Hanya ada satu node
            tail = null;
        } else {
            tail.next = head.next; // lewati head
        }
        totalAntrian--;
    }

    // Cetak semua pelanggan dari depan sampai belakang
    @Override
    public void tampilkanAntrian() {
        if (isEmpty()) {
            System.out.println("(Antrian TAKEAWAY kosong)");
            return;
        }

        Node current = tail.next; // mulai dari head
        do {
            System.out.println(current.data);
            current = current.next;
        } while (current != tail.next); // berhenti saat kembali ke head
    }

    @Override
    public boolean isEmpty() {
        return tail == null;
    }
}