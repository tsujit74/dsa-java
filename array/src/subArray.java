public class subArray {
    public static void subArrays(int a[]){
        for (int i = 0;i<a.length;i++){
            int cur = a[i];
            for (int j = i+1;j<a.length;j++){
                System.out.print("("+cur+","+a[j]+")");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int a[] = {2,3,4,5,8};
        subArrays(a);
    }
}
