package Utils.math;

import java.math.BigInteger;

import Utils.Exceptions.NegativeOnFactorialException;

public class Factorial {
    /**
     *  factorial for int n, it may overflow!.
     */
    public static BigInteger factorial(int n){
        if (n > 0){
            BigInteger result = new BigInteger("1");
            BigInteger i = new BigInteger("1");
            for (; i.intValue() <= n ; ) {
                result = result.multiply(i);
                i = i.add(BigInteger.ONE);
            }
            return result;
        }
        else if (n == 0){
            return BigInteger.ONE;
        }
        else{
            throw new NegativeOnFactorialException(); 
        }
    }
}
