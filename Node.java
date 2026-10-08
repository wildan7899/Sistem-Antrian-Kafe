public class Node {
    public Customer data;
    public Node next;
    public Node prev; // Digunakan untuk Double Linked List

    public Node(Customer data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
