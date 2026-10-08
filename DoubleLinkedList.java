public class DoubleLinkedList extends AntrianKafe {
    protected Node head, tail;

    @Override
    public void tambahPelanggan(Customer c) {
        Node newNode = new Node(c);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        totalAntrian++;
    }

    @Override
    public void hapusPelanggan() {
        if (isEmpty()) return;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        totalAntrian--;
    }

    @Override
    public void tampilkanAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
}
