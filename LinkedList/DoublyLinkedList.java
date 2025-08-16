public class doublyLinkedList {
    public static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // Add first in Doubly LinkedList
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Add last in DoublyLinkedList 1<->2<->3<->4<->5<->null
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // Remove First
    public int removeFirst() {
        if (size == 0) {
            System.out.println("Linked List is empty!");
            return -1;
        }
        int val = head.data;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
        return val;
    }

    // Remove Last from the DOubly LinkedList 1<->2<->3<->4<->5<->null
    public void removeLast() {
        if (size == 0) {
            System.out.println("Linked List is empty!");
            return;
        }
        if (size == 1) {
            head = tail = null;
            size--;
            return;
        }
        tail = tail.prev;
        tail.next = null;
        size--;
        return;
    }

    // Add elemnt at any index 1<->2<->3<->4<->5<->6<->7<->null
    public void addAt(int idx, int data) {
        if (idx < 0 || idx > size) {
            System.out.println("Invalid index. Index should be between 0 and " + size);
            return;
        }
        if (idx == 0) {
            addFirst(data);
            return;
        } else if (idx == size) {
            addLast(data);
            return;
        }

        Node newNode = new Node(data);
        size++;
        Node temp = head;
        for (int i = 0; i < idx - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
    }

    // Print Doubly Linked list
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        doublyLinkedList dll = new doublyLinkedList();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.addLast(4);
        dll.addLast(5);

        dll.print();
        // dll.addAt(2, 15);
        System.out.println(dll.size);
        dll.addAt(5, 0);
        dll.print();
        System.out.println(dll.size);
        dll.removeLast();
        //dll.removeLast();
        dll.print();
        System.out.println(dll.size);
    }
}