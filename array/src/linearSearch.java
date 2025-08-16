public class linearSearch {
    public static int findElement(int a[],int key){
        for (int i = 0; i<a.length;i++){
            if (a[i] == key){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int a[] = {10,23,40,35,46,80};
        int index = findElement(a, 35);
        System.out.println("Found at index at: "+index);
    }
}
