package model;

public class CircularLinkedList extends AntrianKafe {
    protected Node tail;

    @Override
    public void tambahPelanggan(Customer c) {
        Node newNode = new Node(c);
        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
        totalAntrian++;
    }

    @Override
    public void hapusPelanggan() {
        if (isEmpty()) return;
        if (tail.next == tail) {
            tail = null;
        } else {
            tail.next = tail.next.next;
        }
        totalAntrian--;
    }

    @Override
    public void tampilkanAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        Node temp = tail.next;
        do {
            System.out.println(temp.data);
            temp = temp.next;
        } while (temp != tail.next);
    }

    @Override
    public boolean isEmpty() {
        return tail == null;
    }
}
