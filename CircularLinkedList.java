class CircularLinkedList extends AntrianKafe {
    private Node tail;

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

    public void hapusPelanggan() {
        if (tail == null) return;
        if (tail.next == tail) {
            tail = null;
        } else {
            tail.next = tail.next.next;
        }
        totalAntrian--;
    }

    public void tampilkanAntrian() {
        if (tail == null) return;
        Node temp = tail.next;
        do {
            System.out.println(temp.data);
            temp = temp.next;
        } while (temp != tail.next);
    }

    public boolean isEmpty() {
        return tail == null;
    }
}
