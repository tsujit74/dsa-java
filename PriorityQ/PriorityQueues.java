import java.util.PriorityQueue;

public class PriorityQueues {
   // for compare object
   static class Student implements Comparable<Student> {
      String name;
      int rank;

      public Student(String name, int rank) {
         this.name = name;
         this.rank = rank;
      }

      // Compare object
      @Override
      public int compareTo(Student s2) {
         return this.rank - s2.rank;
      }
   }

   public static void main(String args[]) {
      // for reverse = PriorityQueue<Integer> pq = new
      // PriorityQueue<>(Comparator.reverseOrder());
      PriorityQueue<Student> pq = new PriorityQueue<>();
      pq.add(new Student("A", 2));
      pq.add(new Student("B", 1));
      pq.add(new Student("C", 5));
      pq.add(new Student("D", 3));

      while (!pq.isEmpty()) {
         System.out.println(pq.peek().name + "->" + pq.peek().rank);
         pq.remove();
      }
   }
}