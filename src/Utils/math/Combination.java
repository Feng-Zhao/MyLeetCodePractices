package Utils.math;

import java.math.BigInteger;

/**
 * Combination, n! / m! * (n-m)!
 */
public class Combination {
    public static BigInteger compose(int n, int m){
        if(m <= n/2){
            return Permutation.permutate(n, m).divide(Factorial.factorial(m)) ;
        }
        else{
            return compose(n, n-m);
        }
    }
    // public static BigInteger compose(int n, int m){
    //     BigInteger fn = Factorial.factorial(n);
    //     BigInteger fm = Factorial.factorial(m);
    //     BigInteger fnm = Factorial.factorial(n-m);
    //     return fn.divide(fm.multiply(fnm));
    // }
}