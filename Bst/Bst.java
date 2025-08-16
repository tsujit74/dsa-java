import java.util.ArrayList;

public class Bst {
   static class Node {
      int data;
      Node left;
      Node right;

      public Node(int data) {
         this.data = data;
      }
   }

   public static Node buildBst(Node root, int val) {
      if (root == null) {
         root = new Node(val);
         return root;
      }

      if (root.data > val) {
         root.left = buildBst(root.left, val);
      } else {
         root.right = buildBst(root.right, val);
      }
      return root;
   }

   public static void inorder(Node root) {
      if (root == null) {
         return;
      }
      inorder(root.left);
      System.out.print(root.data + " ");
      inorder(root.right);
   }

   //preorde
   public static void preorder(Node root){
      if (root == null) {
         return;
      }
      System.out.print(root.data+" ");
      preorder(root.left);
      preorder(root.right);
   }

   // Search in BSt
   public static boolean search(Node root, int key) {
      if (root == null) {
         return false;
      }
      if (root.data == key) {
         return true;
      }
      if (root.data > key) {
         return search(root.left, key);
      } else {
         return search(root.right, key);
      }
   }

   // Delete a node
   public static Node delete(Node root, int val) {
      if (root.data < val) {
         root.right = delete(root.right, val);
      } else if (root.data > val) {
         root.left = delete(root.left, val);
      } else {
         // case 1--> delete leaf NODe
         if (root.left == null && root.right == null) {
            return null;
         }
         // case 2--> delete single child
         if (root.left == null) {
            return root.right;
         } else if (root.right == null) {
            return root.left;
         }
         // case 3--> have both chldren
         Node IS = findInorderSuccessor(root.right);
         root.data = IS.data;
         root.right = delete(root.right, IS.data);
      }
      return root;
   }

   public static Node findInorderSuccessor(Node root) {
      while (root.left != null) {
         root = root.left;
      }
      return root;
   }

   // print in range
   public static void printInRange(Node root, int k1, int k2) {
      if (root == null) {
         return;
      }
      if (root.data >= k1 && root.data <= k2) {
         printInRange(root.left, k1, k2);
         System.out.print(root.data + " ");
         printInRange(root.right, k1, k2);
      } else if (root.data < k1) {
         printInRange(root.left, k1, k2);
      } else {
         printInRange(root.right, k1, k2);
      }
   }

   // root to leaf path
   public static void printPath(ArrayList<Integer> path) {
      for (int i = 0; i < path.size(); i++) {
         System.out.print(path.get(i) + "->");
      }
      System.out.print("null");
      System.out.println();
   }

   public static void printRoot2leaf(Node root, ArrayList<Integer> path) {
      if (root == null) {
         return;
      }
      path.add(root.data);
      if (root.left == null && root.right == null) {
         printPath(path);
      }
      printRoot2leaf(root.left, path);
      printRoot2leaf(root.right, path);
      path.remove(path.size() - 1);
   }

   // Valid bst
   public static boolean isValid(Node root, Node min, Node max) {
      if (root == null) {
         return true;
      }
      if (min != null && root.data <= min.data) {
         return false;
      } else if (max != null && root.data >= max.data) {
         return false;
      }
      return isValid(root.left, min, root) && isValid(root.right, root, max);
   }

   // sorted array to blanced bst
   public static Node createBst(int arr[], int st, int end) {
      if (st > end) {
         return null;
      }
      int mid = (st + end) / 2;
      Node root = new Node(arr[mid]);
      root.left = createBst(arr, st, mid - 1);
      root.right = createBst(arr, mid + 1, end);

      return root;
   }

   //BSt to Blanced Bst
   public static void getInorder(Node root,ArrayList<Integer> inorder){
      if (root == null) {
         return;
      }
      getInorder(root.left, inorder);
      inorder.add(root.data);
      getInorder(root.right, inorder);
   }
   public static Node createBstBlanced(ArrayList<Integer> inorder,int st,int end){
      if (st>end) {
         return null;
      }
      int mid  = (st+end)/2;
      Node root = new Node(inorder.get(mid));
      root.left = createBstBlanced(inorder, st, mid-1);
      root.right = createBstBlanced(inorder, mid+1, end);
      return root;
   }
   public static Node blancedBst(Node root){
      //inorder sequence
      ArrayList<Integer> inorder = new ArrayList<>();
      getInorder(root, inorder);
      //sorted inorder  -- Blanced Bst
      root = createBstBlanced(inorder, 0, inorder.size()-1);
      return root;
   }

   public static void main(String args[]) {
      // int values[] = { 5, 1, 3, 4, 2, 7 };
      // int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
      //int arr[] = {3,5,6,8,10,11,12};
      int values[] = { 8, 5, 3, 6, 10, 11, 14 };
      Node root = null;

      for (int i = 0; i < values.length; i++) {
         root = buildBst(root, values[i]);
      }

      

   }
}
