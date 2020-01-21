
import java.util.*;

public class p17_Letters_of_a_Phone_Number {
    // final Logger logger = LoggerFactory.getLogger(p17_Letters_of_a_Phone_Number.class);
    public List<String> sol_1(String digits) {
        if(digits.length() < 1){
            return new ArrayList<>();
        }
        int count = 1;
        char2String c2s = new char2String();
        //how many combinations we need;
        for (int i = 0; i < digits.length(); i++) {
            count *= c2s.numchar2str(digits.charAt(i)).length();
        }
        String[] result = new String[count];
        for (int i = 0; i < count; i++) {
            result[i] = "";
        }
        //steps between we go to next char;
        int onePartLength = 1;
        //change here and below result[cur]'s line achieve logical order
        //for(int i = digits.length()-1; i >= 0; i--){
        for (int i = 0; i < digits.length(); i++) {
            int cur = 0;
            //update the results by position;
            while(cur < count){
                int readPos =
                        (cur/onePartLength)  % c2s.numchar2str(digits.charAt(i)).length();
                result[cur] += c2s.numchar2str(digits.charAt(i)).charAt(readPos);
//                result[cur] = c2s.numchar2str(digits.charAt(i)).charAt(readPos) + result[cur];
                cur++;
            }
            //update the steps;
            onePartLength *= c2s.numchar2str(digits.charAt(i)).length();
        }
        return Arrays.asList(result);
    }
    static class char2String{
        static private Map<Character,String> map = new HashMap<>();
//        static final Logger logger = LoggerFactory.getLogger(char2String.class);
        public char2String(){
            map.put('2',"abc");
            map.put('3',"def");
            map.put('4',"ghi");
            map.put('5',"jkl");
            map.put('6',"mno");
            map.put('7',"pqrs");
            map.put('8',"tuv");
            map.put('9',"wxyz");
        }
        public String numchar2str(char c){
//            logger.debug(map.get(c));
            return map.get(c);
        }
    }

    static public void main(String[] arg){
        p17_Letters_of_a_Phone_Number sol = new p17_Letters_of_a_Phone_Number();
        String test_t = "279";
        List<String> re = sol.sol_1(test_t);
        System.out.println(re.toString());
    }
}
