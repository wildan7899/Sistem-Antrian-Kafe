package model;

// Antrian takeaway pakai Circular Linked List (tail.next nyambung balik ke head)
public class CircularLinkedList extends AntrianKafe {

    private static class Node {
        Pelanggan data;
        Node next;

        Node(Pelanggan data) {
            this.data = data;
        }
    }

    // Cukup simpan pointer tail, karena tail.next otomatis adalah head
    private Node tail;

    @Override
    public void tambahPelanggan(Pelanggan pelanggan) {
        if (pelanggan == null) return;

        Node newNode = new Node(pelanggan);
        if (tail == null) {
            newNode.next = newNode; // nunjuk ke dirinya sendiri
            tail = newNode;
        } else {
            newNode.next = tail.next; // newNode nyambung ke head
            tail.next = newNode;      // tail lama nyambung ke newNode
            tail = newNode;           // newNode jadi tail baru
        }
        totalAntrian++;
        System.out.println("[+] Masuk antrian TAKEAWAY: " + pelanggan);
    }

    @Override
    public void hapusPelanggan() {
        if (apakahKosong()) {
            System.out.println("[!] Antrian TAKEAWAY kosong, tidak ada pelanggan untuk dilayani.");
            return;
        }

        Node head = tail.next;
        Pelanggan dilayani = head.data;

        if (head == tail) {
            tail = null; // sisa 1 node terus dihapus
        } else {
            tail.next = head.next; // bypass head lama
        }
        totalAntrian--;
        System.out.println("[-] Melayani pelanggan (FIFO): " + dilayani);
    }

    @Override
    public void tampilkanAntrian() {
        System.out.println("=== DAFTAR ANTRIAN: TAKEAWAY (Circular Linked List) ===");
        if (apakahKosong()) {
            System.out.println("[ Antrian kosong ]");
            System.out.println("Total: 0 orang");
            return;
        }

        Node current = tail.next; // mulai dari head
        int no = 1;
        do {
            System.out.println(no + ". " + current.data);
            current = current.next;
            no++;
        } while (current != tail.next); // berhenti kalau udah muter balik ke head

        System.out.println("Total Antrian: " + totalAntrian + " orang");
    }

    @Override
    public boolean apakahKosong() {
        return tail == null;
    }
}
