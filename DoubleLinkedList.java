class DoubleNode {
    Customer data;
    DoubleNode prev, next;

    public DoubleNode(Customer data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoubleLinkedList extends AntrianKafe {
    private DoubleNode head, tail;

    public void tambahPelanggan(Customer c) {
        DoubleNode newNode = new DoubleNode(c);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        totalAntrian++;
    }

    public void hapusPelanggan() {
        if (head == null) return;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        totalAntrian--;
    }

    public void tampilkanAntrian() {
        DoubleNode temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }
}
