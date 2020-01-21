package problems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p8_myAtoi {
    final Logger logger = LoggerFactory.getLogger(p8_myAtoi.class);

    //use pattern to extract the digital part
    public int sol_1(String str) {
        Pattern p = Pattern.compile("^(\\s*)(\\+)?(-)?(\\d+)(.*)$");
//        logger.debug(p.pattern());
        Matcher m=p.matcher(str);
        if(m.matches()){
            if(m.group(3) != null && m.group(2) != null){
                return 0;
            }
            double num = Double.valueOf(m.group(4));

            if(m.group(3) != null){
                num = -1 * num;
            }
            if(num == Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            else if(num == Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            else {
                return (int)num;
            }
        }
        return 0;
    }

    //normal Atoi without pattern
    public int sol_2(String str){
        double leftLimit = -2147483648, rightLimit = 2147483647, nmbToInt = 0;
        boolean sign = false; // false -> there is a "+"
        int q = 0;
        if(str.length() == 0) {
            return 0;
        }
        while(str.charAt(q) == ' ' && q < str.length()){
            q++;
            if(q == str.length()) {
                return 0;
            }
        }
        if(str.charAt(q) == '-') {
            sign = true;
            q++;
        } else if(str.charAt(q) == '+') {
            sign = false;
            q++;
        }

        for(int i = q; i < str.length(); i++) {
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                nmbToInt = nmbToInt * 10 + (str.charAt(i) - '0');
            } else {
                break;
            }

        }
        if(sign == true) {
            nmbToInt = nmbToInt *(-1);
        }
        if(nmbToInt < leftLimit || nmbToInt > rightLimit) {
            if(nmbToInt < leftLimit) {
                return (int)leftLimit;
            } else {
                return (int)rightLimit;
            }
        }
        return (int)(nmbToInt);
    }
    static public void main(String[] arg){
        p8_myAtoi sol = new p8_myAtoi();
        String test = " q  321089789013840 adklkd lakslkf";
        int re = sol.sol_1(test);
        System.out.println(re);
    }
}
