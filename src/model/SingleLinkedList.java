package model;

public class SingleLinkedList extends AntrianKafe {

    private static class Node {
        Customer data;
        Node next;

        Node(Customer data) {
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
    public void tambahPelanggan(Customer customer) {
        Node newNode = new Node(customer);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        totalAntrian++;
        System.out.println("Pelanggan berhasil ditambahkan ke Single Linked List: " + customer);
    }

    @Override
    public void hapusPelanggan() {
        if (isEmpty()) {
            System.out.println("Antrian kosong! Tidak ada pelanggan yang dapat dihapus.");
            return;
        }

        Customer removedCustomer = head.data;
        head = head.next;
        totalAntrian--;

        if (head == null) {
            tail = null; 
        }

        System.out.println("Melayani / Menghapus pelanggan (FIFO): " + removedCustomer);
    }

    @Override
    public void tampilkanAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian kafe saat ini kosong.");
            return;
        }

        System.out.println("=== DAFTAR ANTRIAN KAFE (SINGLE LINKED LIST) ===");
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
    public boolean isEmpty() {
        return head == null;
    }
}