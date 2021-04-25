package Utils.math;

import java.math.BigInteger;

public class Permutation {
    public static BigInteger permutate(int n, int m){
        BigInteger result = new BigInteger(String.valueOf("1"));
        
        for (int i = 0; i < m; i++) {
            result = result.multiply(new BigInteger(String.valueOf(n-i)));
        }
        return result;
    }
}
