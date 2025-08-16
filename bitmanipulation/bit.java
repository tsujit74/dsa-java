class bit {
    // ODD EVEN
    public static void oddOrEven(int n) {
        int bitMask = 1;
        if ((n & bitMask) == 0) {
            System.out.println("EVEN");
        } else {
            System.out.println("ODD");
        }
    }

    // get ith bit
    public static int getIthBit(int n, int i) {
        int bitMask = 1 << i;
        if ((n & bitMask) == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    // set ith bit
    public static int setIthBit(int n, int i) {
        int bitMask = 1 << i;
        return n | bitMask;
    }

    // clear ith bit
    public static int clearIthBit(int n, int i) {
        int bitMask = ~(1 << i);
        return n & bitMask;
    }

    // UPDATE ith bit
    public static int updateIthBit(int n, int i, int newBit) {
        System.out.println("UPdate ith bit");
        // if (newBit == 0) {
        // return clearIthBit(n, i);
        // }else{
        // return setIthBit(n, i);
        // }
        n = clearIthBit(n, i);
        int bitMask = newBit << i;
        return n | bitMask;
    }

    // clear last ith bit
    public static int clearIbits(int n, int i) {
        System.out.println("CLear ith bit");
        int bitMask = ~(0) << i;
        return n & bitMask;
    }

    // clear range of bits
    public static int clearRangeBits(int n, int i, int j) {
        System.out.println("CLear range of bit");
        int a = ((~0) << (j + 1));
        int b = (1 << i) - 1;
        int bitMask = a | b;
        return n & bitMask;
    }

    // number of power of 2 or not
    public static boolean isPowerOfTwo(int n) {
        System.out.println("Power of two or Not");
        return (n & (n - 1)) == 0;
    }

    // count 1 in a number
    public static int countSetBit(int n) {
        System.out.println("Count 1");
        int count = 0;
        while (n > 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static int fastExpo(int a, int n) {
        System.out.println("fast Exponential");
        int ans = 1;
        while (n > 0) {
            if ((n & 1) != 0) {
                ans = ans * a;
            }
            a = a * a;
            n = n >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        oddOrEven(10);
        System.out.println(getIthBit(10, 3));
        System.out.println(setIthBit(10, 2));
        System.out.println(clearIthBit(15, 2));
        System.out.println(updateIthBit(10, 2, 1));
        System.out.println(clearIbits(15, 2));
        System.out.println(clearRangeBits(10, 2, 4));
        System.out.println(isPowerOfTwo(15));
        System.out.println(countSetBit(10));
        System.out.println(fastExpo(5, 3));
    }
}