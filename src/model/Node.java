package model;

public class Node {
    public Customer data;
    public Node next;
    public Node prev;

    public Node(Customer data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
