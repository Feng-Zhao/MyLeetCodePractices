package problems;

public class p9_Palindrome_Number {
    //find the center and check the dual direction.
    public boolean sol_1(int x) {
        if (x < 0 ){
            return false;
        }
        String s = Integer.toString(x);
        for(int i = 0; i < s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    //revers the int and check whether they are the same
    public boolean sol_2(int x){
        if(x >= 0 && x < 9) return true;
        if(x < 0 || x%10 == 0 ) return false;
        int reverse = 0;
        int  n = x;
        while (x>0){
            int rem = x%10;
            reverse = reverse*10 + rem;
            x = x/10;
        }
        return n ==  reverse;
    }

    static public void main(String[] arg){
        p9_Palindrome_Number sol = new p9_Palindrome_Number();
        int test = 12321;
        boolean re = sol.sol_1(test);
        System.out.println(re);
    }
}
