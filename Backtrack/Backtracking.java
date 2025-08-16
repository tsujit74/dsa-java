public class Backtracking {
    // For printing array
    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // rat maze
    /*
     * { 1, 1, 1, 1 },
     * { 0, 1, 0, 1 },
     * { 1, 1, 1, 1 },
     * { 1, 0, 1, 1 }
     */

    public static void printTwoDarray(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Change Array
    public static void changArr(int arr[], int i, int val) {
        if (i == arr.length) {
            printArr(arr);
            return;
        }
        arr[i] = val;
        changArr(arr, i + 1, val + 1);
        arr[i] = arr[i] - 2;
    }

    // print all subset of given array
    public static void findSubset(String str, int i, String ans) {
        if (i == str.length()) {
            if (ans.length() != 0) {
                System.out.print(ans + " ");
            }
            return;
        }

        findSubset(str, i + 1, ans + str.charAt(i));
        findSubset(str, i + 1, ans);
    }

    // find premutation
    public static void premutation(String str, String ans) {
        if (str.length() == 0) {
            System.out.print(ans + " ");
        }

        for (int i = 0; i < str.length(); i++) {
            char curnt = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1);
            premutation(newStr, ans + curnt);
        }
    }

    // Place Queen in a chess board
    public static boolean isSafe(char board[][], int row, int col) {
        // verticle up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // diagonal left up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // diagonal right up
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void nQueen(char board[][], int row) {
        if (row == board.length) {
            System.out.println("------CHESS BOARD------");
            printBoard(board);
            count++;
            return;
        }

        // column
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nQueen(board, row + 1);
                board[row][j] = 'X';
            }
        }
    }

    public static void printBoard(char board[][]) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print("|" + board[i][j] + "|");
            }
            System.out.println();
        }
    }

    static int count = 0;
    // nqueen end here

    // find all the path for reaching the initial point(0,0) to (n*n)
    public static void findAllPath(int arr[][], int i, int j, int n, boolean visited[][], String p) {
        if (i < 0 || j < 0 || i >= n || j >= n) {
            return;
        }

        if (arr[i][j] == 0 || visited[i][j] == true) {
            return;
        }

        if (i == n - 1 && j == n - 1) {
            System.out.println("reached:-" + p);
            return;
        }

        visited[i][j] = true;

        findAllPath(arr, i - 1, j, n, visited, p + "u");
        findAllPath(arr, i + 1, j, n, visited, p + "d");
        findAllPath(arr, i, j - 1, n, visited, p + "l");
        findAllPath(arr, i, j + 1, n, visited, p + "r");

        visited[i][j] = false;
    }

    // grid Ways find aloow to right and down 0,0 to n-1,n-1;
    public static int gridWays(int i, int j, int n, int m) {
        if (i == n - 1 && j == m - 1) {
            return 1;
        } else if (i == m || j == m) {
            return 0;
        }

        int w1 = gridWays(i + 1, j, n, m);
        int w2 = gridWays(i, j + 1, n, m);
        return w1 + w2;
    }

    // write a code for sudoku
    public static boolean isSafe(int sudoku[][], int row, int col, int digit) {
        // column
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] == digit) {
                return false;
            }
        }
        // row
        for (int j = 0; j < 9; j++) {
            if (sudoku[row][j] == digit) {
                return false;
            }
        }
        // grid
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;
        // 3*3
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (sudoku[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean sudokuSolver(int sudoku[][], int row, int col) {
        if (row == 9) {
            return true;
        }
        int nextRow = row;
        int nextCol = col + 1;

        if (col + 1 == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }
        if (sudoku[row][col] != 0) {
            return sudokuSolver(sudoku, nextRow, nextCol);
        }
        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(sudoku, row, col, digit)) {
                sudoku[row][col] = digit;
                if (sudokuSolver(sudoku, nextRow, nextCol)) {// solution exist
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }
        return false;
    }

    public static void printSoduko(int sudoku[][]) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }
    //End soduko

    //KEYPAD COMBINATION
    final static char[][] keypad = {
        {},
        {},
        {'a','b','c'},
        {'d','e','f'},
        {'g','h','i'},
        {'j','k','l'},
        {'m','n','o'},
        {'q','q','r','s'},
        {'t','u','v'},
        {'w','x','y','z'},
    };

    public static void letterCombination(String giveString){
        int len = giveString.length();
        if (len==0) {
            System.out.println("");
        }
        recursive_func(0,len,"",giveString);
    }
    public static void recursive_func(int pos,int len,String ansStr,String givenString){
        if (pos==len) {
            System.out.print(ansStr+" ");
        }else{
            char[] letter = keypad[givenString.charAt(pos)-'0'];
            for(int i=0;i<letter.length;i++){
                recursive_func(pos+1, len, ansStr+letter[i], givenString);
            }
        }
    }

    public static void main(String[] args) {
        int arr[][] = { { 1, 1, 1, 1 }, { 0, 1, 0, 1 }, { 1, 1, 1, 1 }, { 1, 0, 1, 1
        } };
        // int arr[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1
        // } };
        int n = arr.length;
        boolean visited[][] = new boolean[n][n];
        findAllPath(arr, 0, 0, n, visited, "");

        // find subset
        String str = "abc";
        findSubset(str, 0, "");

        // find permutation
        System.out.println();
        premutation(str, "");

        // nQueen problem
        System.out.println("Nqueen problem");
        int bn = 4;
        char board[][] = new char[bn][bn];
        for (int i = 0; i < bn; i++) {
            for (int j = 0; j < bn; j++) {
                board[i][j] = 'X';
            }
        }
        nQueen(board, 0);
        System.out.println("Total ways: " + count);

        // grid ways
        System.out.println("grid ways: " + gridWays(0, 0, 3, 3));

        // SUDOKU
        int sudoku[][] = {
                // {0,0,8,0,0,0,0,0,0},
                // {4,9,0,1,5,7,0,0,2},
                // {0,0,3,0,0,4,1,9,0},
                // {1,8,5,0,6,0,0,2,0},
                // {0,0,0,0,2,0,0,6,0},
                // {9,6,0,4,0,5,3,0,0},
                // {0,3,0,0,7,2,0,0,4},
                // {0,4,9,0,3,0,0,5,7},
                // {8,2,7,0,0,9,0,1,3}
                { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
                { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
                { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
                { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
                { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
                { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
                { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
                { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
                { 0, 0, 0, 0, 8, 0, 0, 7, 9 }
        };
        printSoduko(sudoku);
        if (sudokuSolver(sudoku, 0, 0)) {
            System.out.println("Solution Exist: ");
            printSoduko(sudoku);
        }else{
            System.out.println("Solution Does Not Exist");
        }

        //Keypad solution
        System.out.println("Keypad Combination: ");
        letterCombination("23");
    }
}