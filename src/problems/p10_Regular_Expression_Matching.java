package problems;

import java.util.regex.Pattern;

public class p10_Regular_Expression_Matching {
    //use the Pattern and Matcher
    public boolean sol_1(String s, String p) {
        Pattern pattern = Pattern.compile("^"+p+"$");
        return pattern.matcher(s).matches();

    }
    static public void main(String[] arg){
        p10_Regular_Expression_Matching sol = new p10_Regular_Expression_Matching();
        String testS = "aaaa";
        String testP = "a";
        boolean re = sol.sol_1(testS,testP);
        System.out.println(re);
    }
}
