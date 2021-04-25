package problems;

import java.net.Socket;
import java.util.Arrays;
import java.util.Set;

class p992_Subarrays_with_K_Different_Integer {
    public int sol_1_BF(int[] A, int K) {
        int results_count = 0;
        for(int pos = 0; pos < A.length; pos++){
            for(int end = pos + K; end < A.length; end++){
                int[] forCheck = Arrays.copyOfRange(A, pos, end);
                // Set<Integer> forCheck
            }
                
        }
        return results_count;
    }

    private boolean check(int[] A, int K){
        for(int c: A){
            
        }  
        return true;
    }
}