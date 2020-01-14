import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class p6_ZigZag_Conversion {
    final Logger logger = LoggerFactory.getLogger(p665_non_decreasing_array.class);

    //use a flag upforword? to mark whether the nextRow is cur+1 or cur-1
    //when cur hit 0 or row-1, revers the direction.
    public String sol_1(String s, int numRows) {
        if(numRows < 2){
            return s;
        }
        boolean upforward = true;
        String[] rows = new String[numRows];
        for(int i = 0; i < numRows; ++i){
            rows[i] = "";
        }
        int curRow = 0;
        for(int i = 0; i < s.length(); ++i){
            rows[curRow] += s.charAt(i);
            if(curRow == 0 || curRow == numRows-1){
                upforward = !upforward;
            }
            curRow += upforward?-1:1;
        }
        String result = "";
        for(String row : rows){
            result += row;
        }
        return result;
    }

    static public void main(String[] arg){

        p6_ZigZag_Conversion sol =
                new p6_ZigZag_Conversion();
        int rows = 3;
        String test = "apatd";
        String re = sol.sol_1(test,rows);
        System.out.println(re);
    }
}
