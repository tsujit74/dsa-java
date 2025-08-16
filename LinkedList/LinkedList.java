public class LinkedList {
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
   public int size;

   // print LinkedList
   public void print() {
      Node temp = head;
      while (temp != null) {
         System.out.print(temp.data + "->");
         temp = temp.next;
      }
      System.out.println("null");
   }

   // Add first Element
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

   // Add in last
   public void addLast(int data) {
      Node newNode = new Node(data);
      size++;
      if (head == null) {
         head = tail = newNode;
         return;
      }
      tail.next = newNode;
      tail = newNode;
   }

   // Add at index point
   public void addAt(int idx, int data) {
      if (idx == 0) {
         addFirst(data);
         return;
      }
      Node newNode = new Node(data);
      size++;
      Node temp = head;
      int i = 0;
      while (i < idx - 1) {
         temp = temp.next;
         i++;
      }
      newNode.next = temp.next;
      temp.next = newNode;
   }

   // Remove first
   public void removeFirst() {
      if (size == 0) {
         System.out.println("Linked List is empty.");
         return;
      } else if (size == 1) {
         head = tail = null;
      }
      head = head.next;
      size--;
   }

   // Remove Last
   public void removeLast() {
      if (size == 0) {
         System.out.println("Linked List is empty.");
         return;
      } else if (size == 1) {
         head = tail = null;
      }
      Node prev = head;
      for (int i = 0; i < size - 2; i++) {
         prev = prev.next;
      }
      prev.next = null;
      tail = prev;
      size--;
   }

   // Search in Linked List
   public int itrSearch(int key) {
      Node temp = head;
      int i = 0;
      while (temp != null) {
         if (temp.data == key) {
            return i;
         }
         temp = temp.next;
         i++;
      }
      return -1;
   }

   // Remove at index
   public void removeAt(int idx) {
      if (idx == 0) {
         removeFirst();
         return;
      } else if (size < idx) {
         System.out.println("Enter the index between 0 to " + size);
         return;
      }
      Node curr = head;
      int i = 0;
      while (i < idx - 1) {
         curr = curr.next;
         i++;
      }
      curr.next = curr.next.next;
      size--;
   }

   // helper
   public int helper(Node head, int key) {
      if (head == null) {
         return -1;
      }
      if (head.data == key) {
         return 0;
      }
      int idx = helper(head.next, key);
      if (idx == -1) {
         return -1;
      }
      return idx + 1;
   }

   // Recursive Iterrative
   public int recursive(int key) {
      return helper(head, key);
   }

   // Reverse the Linked List 1->2->3->4->5->null
   public void reverse() {
      Node prev = null;
      Node curr = tail = head;
      Node next;

      while (curr != null) {
         next = curr.next;
         curr.next = prev;
         prev = curr;
         curr = next;
      }
      head = prev;
   }

   // Delete the node from the last Nth node
   public void removeLastNth(int nth) {
      if (nth == size) {
         removeFirst();
         return;
      } else if (nth > size) {
         System.out.println("Not valid!");
         return;
      }
      nth = size - nth + 1;
      Node curr = head;
      int idx = nth - 1;
      int i = 0;
      while (i < idx - 1) {
         curr = curr.next;
         i++;
      }
      curr.next = curr.next.next;
      size--;
   }

   // Delete the node from the nth last
   public void deleteNthFromEnd(int nth) {
      int size = 0;
      Node temp = head;
      while (temp != null) {
         temp = temp.next;
         size++;
      }
      if (nth == size) {
         head = head.next;// removeFirst
      }
      // nth = size-nth+1;
      Node prev = head;
      int i = 1;
      int itofind = size - nth;
      while (i < itofind) {
         prev = prev.next;
         i++;
      }
      prev.next = prev.next.next;
      // return;
   }

   // slow fast approach for finding a mid
   public Node findMid(Node head) {
      Node slow = head;
      Node fast = head;

      while (fast != null && fast.next != null) {
         slow = slow.next;// +1
         fast = fast.next.next;// +2
      }
      return slow;
   }

   // Linked List is palindrome or not
   public boolean checkPalindrome() {
      if (head == null || head.next == null) {
         return true;
      }
      // step-1 find the mid
      Node midNode = findMid(head);

      // step-2 reverse the right part
      Node prev = null;
      Node curr = midNode;
      Node next;
      while (curr != null) {
         next = curr.next;
         curr.next = prev;
         prev = curr;
         curr = next;
      }
      Node right = prev; // Right half head
      Node left = head;

      // step-3 check left half and right half
      while (right != null) {
         if (left.data != right.data) {
            return false;
         }
         left = left.next;
         right = right.next;
      }
      return true;
   }

   // Check Linke list cycle is exist or not
   public static boolean isCycle() {
      Node slow = head;
      Node fast = head;
      while (fast != null && fast.next != null) {
         slow = slow.next;// +1
         fast = fast.next.next;// +2
         if (slow == fast) {
            return true;
         }
      }
      return false;
   }

   // get mid for merge SOrt
   private Node getMid(Node head) {
      Node slow = head;
      Node fast = head.next;
      while (fast != null && fast.next != null) {
         slow = slow.next;
         fast = fast.next.next;
      }
      return slow;// mid Node
   }

   private Node merge(Node head1, Node head2) {
      Node mergedLL = new Node(-1);
      Node temp = mergedLL;
      while (head1 != null && head2 != null) {
         if (head1.data <= head2.data) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
         } else {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
         }
      }
      while (head1 != null) {
         temp.next = head1;
         head1 = head1.next;
         temp = temp.next;
      }
      while (head2 != null) {
         temp.next = head2;
         head2 = head2.next;
         temp = temp.next;
      }
      return mergedLL.next;
   }

   public Node mergeSort(Node head) {
      if (head == null || head.next == null) {
         return head;
      }
      Node mid = getMid(head);
      Node rightHead = mid.next;
      mid.next = null;
      Node newleft = mergeSort(head);
      Node newRight = mergeSort(rightHead);
      return merge(newleft, newRight);
   }

   // Zigzag ex 1->2->3->4->5->null op 1->5->2->4->3->null
   public void zigZag() {
      System.out.println("ZigZag: ");
      Node slow = head;
      Node fast = head.next;
      while (fast != null && fast.next != null) {
         slow = slow.next;
         fast = fast.next.next;
      }
      Node mid = slow;
      // reverse 2nd half
      Node curr = mid.next;
      mid.next = null;
      Node prev = null;
      Node next;
      while (curr != null) {
         next = curr.next;
         curr.next = prev;
         prev = curr;
         curr = next;
      }

      Node left = head;
      Node right = prev;
      Node nextL, nextR;

      // alt merge - zigzag merge
      while (left != null && right != null) {
         nextL = left.next;
         left.next = right;
         nextR = right.next;
         right.next = nextL;

         left = nextL;
         right = nextR;
      }
   }

   // delete n node after m node
   // m=2,n=2 1->2->3->4->5->6->null op = 1->2->5->6->null
   // m for keep , n for delete
   public Node deleteNnodeAfterMnode(Node head, int m, int n) {
      Node temp = head;
      while (temp != null) {
         for (int i = 1; i < m; i++) {
            temp = temp.next;
         }
         if (temp == null || temp.next == null) {
            return head;
         }
         for (int i = 0; i < n; i++) {
            temp.next = temp.next.next;
         }
         temp = temp.next;
      }
      return head;
   }

   // Odd even LinkedList
   // : 8->12->10->5->4->1->6->NULL = 8->12->10->4->6->5->1->NULL
   public Node oddEven() {
      Node newEven = new Node(-1);
      Node newOdd = new Node(-1);
      Node tempEven = newEven;
      Node tempOdd = newOdd;
      Node temp = head;
      while (temp != null) {
         if (temp.data % 2 == 0) {
            tempEven.next = new Node(temp.data);
            tempEven = tempEven.next;
         } else {
            tempOdd.next = new Node(temp.data);
            tempOdd = tempOdd.next;
         }
         temp = temp.next;
      }
      tempEven.next = null;
      tempOdd.next = null;
      tempEven.next = newOdd.next;
      return newEven.next;
   }

   public static void main(String args[]) {
      LinkedList ll = new LinkedList();
      // ll.addFirst(10);
      // ll.addFirst(9);
      // ll.addFirst(8);
      ll.addFirst(6);
      ll.addFirst(1);
      ll.addFirst(4);
      ll.addFirst(5);
      ll.addFirst(10);
      ll.addFirst(12);
      ll.addFirst(8);
      ll.print();
      Node deleteNode = ll.oddEven();
      while (deleteNode != null) {
         System.out.print(deleteNode.data + "->");
         deleteNode = deleteNode.next;
      }
      System.out.println("null");

      ll.head = ll.mergeSort(ll.head);
      ll.print();
   }
}