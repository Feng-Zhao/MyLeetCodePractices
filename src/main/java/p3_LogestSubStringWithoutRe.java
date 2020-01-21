import java.util.HashMap;
import java.util.Map;

public class p3_LogestSubStringWithoutRe {
    public int Sol_1_BroutForece(String s) {
        int start = 0;
        int end = s.length();
        int max = 0;
        String sub;
        for (; end > start; start++) {
            for (; end > start; end--) {
                sub = s.substring(start, end);
                if (!this.hasRepeat(sub)) {
                    if (sub.length() > max) {
                        max = sub.length();
                    }
                }
            }
            end = s.length();
        }
        return max;
    }

    private boolean hasRepeat(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> checkMap = new HashMap<Character, Integer>();
        for(char c : chars){
            if(checkMap.containsKey(c)){
                return true;
            }
            checkMap.put(c,Character.hashCode(c));
        }
        return false;
    }

    //scan the string when we meet the repeat char,
    //cut the string into two parts
    //(start,pos),(pos+1,end)
    //return max(left_s.len, cutoff(right_s))
    //this is a divide and conquer algorithm with recursive
    public int Sol_2_cutoff(String s) {
        if(s.length()<=1){
            return s.length();
        }
        else {
            String right_s;
            Map<Character, Integer> checkMap = new HashMap<>();
            for (int pos = 0; pos < s.length(); pos++) {
                char now = s.charAt(pos);
                if (checkMap.containsKey(now)) {
                    int left = checkMap.get(now);
                    int right = pos;
                    right_s = s.substring(left + 1, s.length());
                    return Math.max(right,Sol_2_cutoff(right_s));
                }
                checkMap.put(s.charAt(pos), pos);
            }
            return s.length();
        }
    }

    public int Sol_2_1_cutoff(String s) {
        int max = 0;
        String sub = "";
        for (int pos = 0; pos < s.length(); pos++) {
            if (sub.indexOf(s.charAt(pos)) != -1) {
                int left = sub.indexOf(s.charAt(pos));
                sub = sub.substring(left+1);
            }
            sub += s.charAt(pos);
            if(sub.length() > max){
                max = sub.length();
            }
        }
        return max;
    }



//    public int Sol_3_count(String s) {
//        List<TwoTuple<Integer,Integer>> list = new ArrayList();
//        Map<Character, List<Integer>> checkMap = new HashMap();
//        for (int pos = 0; pos < s.length(); pos++) {
//            char now = s.charAt(pos);
//            if (checkMap.containsKey(now)) {
//                int left = checkMap.get(now);
//                int right = pos;
//
//
//            }
//            checkMap.put(s.charAt(pos), pos);
//        }
//    }


    static public void main(String arg[]){
        p3_LogestSubStringWithoutRe sol = new p3_LogestSubStringWithoutRe();
        String test = "abbbasdaaa";
//        int result = sol.Sol_1_BroutForece(test);
        int result2 = sol.Sol_2_cutoff(test);
//        System.out.println("Sol_1_BroutForece: " + result);
        System.out.println("Sol_2_cutoff: " + result2);
    }

    class TwoTuple<A, B> {
        public final Integer first;
        public final Integer second;
        public TwoTuple(Integer a, Integer b) {
            first = a;
            second = b;
        }
        public String toString() {
            return "("+ first + "," + second + ")";
        }
    }
}

