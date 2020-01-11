import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class p13_Roman_to_Integer {
    public int sol_1(String s) {
        int base = 1;
        int cur = 0;
        int re = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        for(int i = s.length()-1; i >= 0; i--){
            cur = map.get(s.charAt(i));
            if(cur < base){
                re -= map.get(s.charAt(i));
            }
            else{
                re += cur;
            }
            if(cur > base){
                base = cur;
            }

        }
        return re;
    }

    static public void main(String[] arg){
        p13_Roman_to_Integer sol = new p13_Roman_to_Integer();
        String test = "MXXXIV";
        int re = sol.sol_1(test);
        System.out.println(re);
    }
}
