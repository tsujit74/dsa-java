public class startWithProblem {
    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;
        int freq;

        public Node() {
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
            freq = 1;
        }
    }

    public static Node root = new Node();

    // insert word into trie and increae the frequency
    public static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            } else {
                curr.children[idx].freq++;
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    // Search in trie
    public static boolean search(String key) {
        Node curr = root;
        for (int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }

    /*
     * start with problem
     * words[] = {"apple","app","mango","man","woman"}
     * prefix = "app" o/p true;
     * prefix = "moon" o/p false;
     */
    public static boolean startWith(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

    /*
     * Count unique substring
     * count total number of distinct substring of the given string
     * str = "ababa" o/p 10 in this given string 10 unique sub string
     */
    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                count += countNodes(root.children[i]);
            }
        }
        return count + 1;
    }

    /*Longest word with all prefix
     * find the longest string in words such that every prefix of it is also in words
     * word = {"a","banana","app","appl","ap","apply","apple"}
     * ans = "apple"
     */
    public static String ans = "";
    public static void longesWord(Node root, StringBuilder temp){
        if(root == null){//in this code this case never reach 
            return;
        }
        for(int i = 0;i<26;i++){
            if(root.children[i] != null && root.children[i].eow == true){
                char ch  = (char) (i+'a');
                temp.append(ch);
                if(temp.length()>ans.length()){
                    ans = temp.toString();
                }
                longesWord(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1); //Back track
            }
        }
    }

    public static void main(String[] args) {
        /*
         * for startWithproblem
         * String words[] = {"apple","app","mango","man","woman"};
         * String prefix = "app";
         * String prefix2 = "moon";
         * 
         * for(int i = 0;i<words.length;i++){
         * insert(words[i]);
         * }
         * System.out.println(startWith(prefix));
         * System.out.println(startWith(prefix2));
         */

        
         /*
         * for count nodes
         * String str = "ababa";
         * for(int i = 0;i<str.length();i++){
         * String suffix = str.substring(i);
         * insert(suffix);
         * }
         * System.out.println(countNodes(root));
         */

         String words[] = {"a","banana","app","appl","ap","apply","apple"};//ans will come based on lexography
         for(int i =0;i<words.length;i++){
            insert(words[i]);
         }
         longesWord(root, new StringBuilder(""));
         System.out.println(ans);
    }
}
