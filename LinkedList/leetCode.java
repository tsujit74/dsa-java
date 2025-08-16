// class leetCode {
//     public static class Node {
//         int data;
//         Node next;

//         public Node(int data) {
//             this.data = data;
//             this.next = null;
//         }
//     }

//     public static Node head;
//     public static Node tail;

//     // get mid for merge SOrt
//     private static Node getMid(Node head) {
//         Node slow = head;
//         Node fast = head.next;
//         while (fast != null && fast.next != null) {
//             slow = slow.next;
//             fast = fast.next.next;
//         }
//         return slow;// mid Node
//     }

//     private static Node merge(Node head1, Node head2) {
//         Node mergedLL = new Node(-1);
//         Node temp = mergedLL;
//         while (head1 != null && head2 != null) {
//             if (head1.data <= head2.data) {
//                 temp.next = head1;
//                 head1 = head1.next;
//                 temp = temp.next;
//             } else {
//                 temp.next = head2;
//                 head2 = head2.next;
//                 temp = temp.next;
//             }
//         }
//         while (head1 != null) {
//             temp.next = head1;
//             head1 = head1.next;
//             temp = temp.next;
//         }
//         while (head2 != null) {
//             temp.next = head2;
//             head2 = head2.next;
//             temp = temp.next;
//         }
//         return mergedLL.next;
//     }

//     public static Node mergeSort(Node head) {
//         if (head == null || head.next == null) {
//             return head;
//         }
//         Node mid = getMid(head);
//         Node rightHead = mid.next;
//         mid.next = null;
//         Node newleft = mergeSort(head);
//         Node newRight = mergeSort(rightHead);
//         return merge(newleft, newRight);
//     }

//     public static void print(Node head) {
//         Node temp = head;
//         while (temp != null) {
//             System.out.print(temp.data + "->");
//             temp = temp.next;
//         }
//         System.out.println("null");
//     }

//     public static void main(String[] args) {
//         Node list = new Node(3);
//         list.next = new Node(8);
//         list.next.next = new Node(6);
//         list.next.next.next = new Node(2);
//         list.next.next.next.next = new Node(9);

//         Node list2 = new Node(3);
//         list2.next = new Node(8);
//         list2.next.next = new Node(6);
//         list2.next.next.next = new Node(2);
//         list2.next.next.next.next = new Node(9);
//         Node lis = mergeSort(list);
//         Node lis2 = mergeSort(list2);

//         Node merge = merge(list, list2);
//         print(merge);
//     }
// }

public class leetCode {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void print(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode meNode = new ListNode(-1);
        ListNode temp = meNode;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
                temp = temp.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
                temp = temp.next;
            }
        }
        while (list1 != null) {
            temp.next = list1;
            list1 = list1.next;
            temp = temp.next;
        }
        while (list2 != null) {
            temp.next = list2;
            list2 = list2.next;
            temp = temp.next;
        }

        return meNode.next;
    }

    //plus 1
    public static void plsuOne(int arr[]){
        for(int i = arr.length-1;i>=0;i--){
            if (arr[i]<=9) {
               arr[i]++;
               System.out.println(arr[i]);
               break;
            }
        }
        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    //sqrt x
    public static int sqrt(int n){
        double y = Math.sqrt(n);
        return (int) y;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);

        ListNode list2 = new ListNode(6);
        list2.next = new ListNode(7);
        list2.next.next = new ListNode(8);
        list2.next.next.next = new ListNode(9);
        list2.next.next.next.next = new ListNode(10);

        ListNode merge = mergeTwoLists(list,list2);
        print(merge);

        int arr[] = {2,3,4,9};
        plsuOne(arr);
        int n = 26;
        System.out.println(sqrt(n));
    }
}