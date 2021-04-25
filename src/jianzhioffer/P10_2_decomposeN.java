package jianzhioffer;


import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import Utils.math.Combination;

public class P10_2_decomposeN {
    static final Logger log = LoggerFactory.getLogger(P10_2_decomposeN.class);
    public int numWays(int n) {
        // O(n!) overtime
        if(n > 2){
            return (numWays(n-1) + numWays(n - 2)) % 1000000007;
        }
        else if (n == 2){
            return 2;
        }
        // n <= 1
        else{
            return 1;
        }
    }

    // the problem can be seen as 
    // how many way to insert 0 to a "1111111111", which is a binary string.
    // Note, the length of final "1110110101" string must be n, 
    // and the first must be 1 !!! bucause the frog must finally stand at the top level.
    // 1 means the frog had standed on thant level, 0 means the frog jump over the level,
    // where there is a 2-step jump happens.
    // thus, when the frog only jump 1 step from the bottom to the top,
    // it seems like 1111111, for example, when n = 7;
    // for the situation of there is exactly 1 time of 2-step jump,
    // there are Combanation(n-1,1) ways, which is c(6,1)
    // and so on, the result should be C(n-1,1) +...+ C(n-n/2,n/2).
    // for the constrian that the max step is 2, there is no way of continuous two '0',
    // so, the maximum '0' the string can accept is n/2.
    public int numWays2(int n) {
        if(n > 2){
            int bitsOfZero = 1;
            // c (n,0) = 1
            BigInteger result = new BigInteger("1");
            BigInteger MOD_CONST = new BigInteger("1000000007");
            while(bitsOfZero <= n/2){
                result = result.add(Combination.compose(n-bitsOfZero, bitsOfZero)).divideAndRemainder(MOD_CONST)[1];
                bitsOfZero++;
            }
            return result.intValue();
        }
        else if (n == 2){
            return 2;
        }
        // n <= 1
        else{
            return 1;
        }
    }

    public int numWays3(int n) {
        int a = 1, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    public static void main(String[] args) {
        P10_2_decomposeN s = new P10_2_decomposeN();
        System.out.println(s.numWays2(44));
        System.out.println(s.numWays3(44));
        // System.out.println(Combination.compose(13, 1));
    }
}