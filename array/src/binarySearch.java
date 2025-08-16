public class binarySearch {
    public static int findElement(int a[],int key){
        int st = 0;
        int end = a.length-1;
        while(st <= end){
            int mid = (st+end)/2;

            if (a[mid] == key){
                return mid;
            }
            if (a[mid] < key){
                st = mid+1;
            }else {
                end = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int a[] = {2,4,6,8,10,12,16,20};
        int key = 2;
        System.out.println("Index at: "+findElement(a, key));
    }
}
