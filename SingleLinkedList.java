class Node {
    Customer data;
    Node next;

    public Node(Customer data) {
        this.data = data;
        this.next = null;
    }
}

class SingleLinkedList extends AntrianKafe {
    private Node head, tail;

    public void tambahPelanggan(Customer c) {
        Node newNode = new Node(c);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        totalAntrian++;
    }

    public void hapusPelanggan() {
        if (head == null) return;
        head = head.next;
        if (head == null) tail = null;
        totalAntrian--;
    }

    public void tampilkanAntrian() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }
}
