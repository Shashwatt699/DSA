package bits;

public class all {
    public static void odd_Even(int n) {
        int bitMask = 1; // Very Important
        if ((n & bitMask) == 1) {
            System.out.println("odd nombre");
        } else {
            System.out.println("even nombre");
        }
    }

    public static int getIthBit(int n, int i) {
        int bitmask = 1 << i;
        if ((n & bitmask) == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static int setIthBit(int n, int i) { // Place 1 at ith position from the right
        int bitMask = 1 << i;
        return n | bitMask; // OR Operation
    }

    public static int clearIthBit(int n, int i) {
        int bitMask = ~(1 << i);
        return n & bitMask;
    }

    public static int updateIthBit(int n, int i, int newBit) {
        // if(newBit == 0){
        // return clearIthBit(n, i);
        // } else{
        // return setIthBit(n, i);
        // }

        n = clearIthBit(n, i);
        int bitmask = newBit << i;
        return n | bitmask;
    }

    public static int clearBits(int n, int i) {
        int bitMask = (~0) << i;
        return n & bitMask;
    }

    public static int cleaIBitsinRange(int n, int i, int j) {
        int a = ((~0) << (j + 1));
        int b = (1 << i) - 1;
        int bitmask = a | b;
        return n & bitmask;
    }

    static boolean isPowerOfTwo(int n) {
        return (n & (n - 1)) == 0;
    }

    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) != 0) {// Checking LSB
                count++;
            }
            n = n >> 1;
        }

        return count;
    }

    public static int fastExpo(int a, int n) {
        int ans = 1;

        while (n > 0) {
            if ((n & 1) != 0) { // Check LSB
                ans = ans * a;
            }
            a = a * a;
            n = n >> 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        // odd_Even(2);
        // odd_Even(23);
        // odd_Even(4);
        // odd_Even(12);
        // odd_Even(17);
        // System.out.println(getIthBit(10, 1));
        // System.out.println(setIthBit(10, 2));
        // System.out.println(clearIthBit(10, 1));
        // System.out.println(updateIthBit(10, 2, 1));
        // System.out.println(clearBits(15, 2));
        // System.out.println(cleaIBitsinRange(10, 2, 4));
        // System.out.println(isPowerOfTwo(4));
        //System.out.println(countSetBits(16));
        System.out.println(fastExpo(3, 2));
    }
}
