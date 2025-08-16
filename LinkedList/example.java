public class example {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // delete n node after n node
    // m=2,n=2 1->2->3->4->5->6->null op = 1->2->5->6->null
    // public void deleteNnodeAfterMnode(Node head) {
    // Node temp = head;
    // int i = 0;
    // int m = 2;
    // int n = 2;
    // while (temp != null) {
    // while (i < m) {
    // System.out.print(temp.data + " ");
    // temp = temp.next;
    // i++;
    // }
    // while (true) {

    // }
    // }
    // }

    // FInd Intersection point of the two linked List
    public static int findIntersection(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;
        while (temp1 != null) {
            while (temp2 != null) {
                if (temp2.data == temp1.data) {
                    return temp1.data;
                }
                temp2 = temp2.next;
            }
            temp2 = head2;
            temp1 = temp1.next;
        }
        return 0;
    }

    // Optimize method for FIND INTERSECTION POINT
    public static int optimalIntersection(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;
        while (temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;
            while (temp1 == null) {
                temp1 = head2;
            }
            while (temp2 == null) {
                temp2 = head1;
            }
        }
        return temp1.data;
    }

    // delete n node after n node
    // m=2,n=2 1->2->3->4->5->6->null op = 1->2->5->6->null
    public static Node deleteNnodeAfterMnode() {
        Node temp = head;
        while (temp != null) {
            int m = 2;
            int n = 2;
            for (int i = 1; i < m; i++) {
                temp = temp.next;
            }
            for (int i = 0; i < n; i++) {
                temp = temp.next.next;
            }
            temp = temp.next;
        }
        return head;
    }

    // Even odd
    // Odd even LinkedList
    // : 8->12->10->5->4->1->6->NULL = 8->12->10->4->6->5->1->NULL
    public static Node evenOdd(Node head) {
        Node newEven = new Node(-1);
        Node newOdd = new Node(-1);
        Node tempEven = newEven;
        Node tempOdd = newOdd;
        while (head != null) {
            if (head.data % 2 == 0) {
                tempEven.next = head;
                head = head.next;
                tempEven = tempEven.next;
            } else {
                tempOdd.next = head;
                head = head.next;
                tempOdd = tempOdd.next;
            }
            newEven.next = newOdd.next;
        }
        return newEven.next;
    }

    // merge LinkedList
    public static Node mergeLinkedList(Node head1, Node head2, Node head3) {
        Node mergedL = new Node(-1);
        Node temp = mergedL;
        while (head1 != null) {
            temp.next = new Node(head1.data);
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2 != null) {
            temp.next = new Node(head2.data);
            head2 = head2.next;
            temp = temp.next;
        }
        while (head3 != null) {
            temp.next = new Node(head3.data);
            head3 = head3.next;
            temp = temp.next;
        }
        temp.next = null;
        return mergedL.next;
    }

    // Print Linked list
    public static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head1 = new Node(4);
        head1.next = new Node(3);
        head1.next.next = new Node(2);
        head1.next.next.next = new Node(1);
        head1.next.next.next.next = null;// 4->5->6->7-null

        Node head2 = new Node(9);
        head2.next = new Node(8);
        head2.next.next = new Node(7);
        head2.next.next.next = new Node(6);
        head2.next.next.next.next = new Node(5);
        head2.next.next.next.next.next = null;

        Node head3 = new Node(13);
        head3.next = new Node(12);
        head3.next.next = new Node(11);
        head3.next.next.next = new Node(10);
        head3.next.next.next.next = null;

        print(head1);
        print(head2);
        print(head3);

        System.out.println("Merged Linked List:");
        Node mergeTwo = mergeLinkedList(head1, head2, head3);
        while (mergeTwo != null) {
            System.out.print(mergeTwo.data + "->");
            mergeTwo = mergeTwo.next;
        }
        System.out.println("null");
    }
}
