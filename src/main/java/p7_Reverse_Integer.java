import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class p7_Reverse_Integer {
    final Logger logger = LoggerFactory.getLogger(p7_Reverse_Integer.class);
    public int sol_1(int x) {
        int rev = reverseNumb(x);
        int revRev = reverseNumb(rev);
        return (x == revRev || x % 10 == 0) ? rev : 0;
    }

    public int reverseNumb(int x) {
        int y = 0;
        while(x != 0) {
            y = (y*10) + x %10;
            x = x / 10;
        }
        return y;
    }

    public int sol_2(int x)
    {
        int reverseX = 0;
        int givenLength = 0;
        while(x!=0){
            if(x>0)
                givenLength = String.valueOf(x).length()-1;
            else
                givenLength = String.valueOf(x).length()-2;
            int mod = x%10;
            reverseX += (mod * Math.pow(10,givenLength));

            if(reverseX==Integer.MIN_VALUE || reverseX==Integer.MAX_VALUE){
                return 0;
            }
            x = x/10;
        }
        return reverseX;
    }


    static public void main(String[] args){
        int test = 1534236462;
        p7_Reverse_Integer sol = new p7_Reverse_Integer();
        int a = sol.sol_2(test);
        System.out.println("a: "+ a);
    }
}
