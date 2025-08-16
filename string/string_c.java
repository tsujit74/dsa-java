import java.util.Arrays;

class string_c {
    public static void concateString() {
        String a = "let's Start ";
        String b = "String!";
        String s = a + b;
        System.out.println(s);
    }

    public static boolean palindromeString() {
        String str = "racecar";
        int n = str.length();
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(n - 1 - i)) {
                System.out.println("Not palindrome!");
                return false;
            } else {
                System.out.println("GIven String '" + str + "' is Palindrome");
                return true;
            }
        }
        return true;
    }

    public static void getShortestPath() {
        String path = "WNEENESENNN";
        int x = 0, y = 0;
        for (int i = 0; i < path.length(); i++) {
            char dir = path.charAt(i);
            if (dir == 'S') {
                y--;
            } else if (dir == 'N') {
                y++;
            } else if (dir == 'W') {
                x--;
            } else {
                x++;
            }
        }
        float x2 = x*x;
        float y2 = y*y;
        float s = (float)Math.sqrt(x2+y2);
        System.out.println("Shortest path: "+s);
    }

    public static void largestString(){
        String fruits[] = {"Mango","Apple","Banana"};
        String largest = fruits[0];
        for(int i=0;i<fruits.length;i++){
            System.out.print(fruits[i]+" ");
        }
        System.out.println();
        for(int i = 1;i<fruits.length;i++){
            if (largest.compareTo(fruits[i])<0) {
                largest = fruits[i];
            }
        }
        System.out.println("Largest String in Array: " +largest);
    }

    //longest common prefix
    public static void longestCommonPrefix(String str[]){
        Arrays.sort(str);
        String s1 = str[0];
        String s2 = str[str.length-1];
        int ind  = 0;
        while (ind<s1.length()&&ind<s2.length()) {
            if (s1.charAt(ind) == s2.charAt(ind)) {
                ind++;
            }else{
                break;
            }
        }
        System.out.println(s1.substring(0, ind));
        
        for(int i = 0;i<str.length;i++){
            System.out.print(str[i]+" ");
        }
    }

    //Find the Index of the First Occurrence in a String
    public static int firstOccurence(String haystack,String needle){
        for(int i = 0;i<haystack.length()-needle.length()+1;i++){
            if (haystack.charAt(i)== needle.charAt(0)) {
                if (haystack.substring(i, needle.length()+i).equals(needle)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // concateString();
        // palindromeString();
        // getShortestPath();
        // largestString();
        // String str[] = {"sujit","suj","suji"};
        System.out.println(firstOccurence("butsad", "sad"));
    }
}