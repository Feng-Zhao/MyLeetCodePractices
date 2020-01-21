package problems;

public class p5_Longest_Palindromic_Substring {
    public String sol_1(String s) {
        if(s == null || s.length() < 1){
            return  "";
        }

        int start, end;
        int min_s = s.length()-1;
        int max_e = 0;
        int max_p_len = 0;

        for (start = 0; start<s.length() - max_p_len ; start++ ){
            for(end = s.length()-1; end >= start; end--) {
                int inner_s = start;
                int inner_e = end;
                boolean is_P = true;

                while (inner_s <= inner_e) {
                    if (s.charAt(inner_s) == s.charAt(inner_e)) {
                        inner_s++;
                        inner_e--;
                    } else {
                        is_P = false;
                        break;
                    }
                }
                if(is_P){
                    if((end-start) > (max_e-min_s)){
                        max_e = end;
                        min_s = start;
                        max_p_len = max_e - min_s + 1;
                    }
                }
            }
        }
        return s.substring(min_s,max_e+1);
    }

    // expand from centers
    // there are 2n-1 centers
    // either at every letters or between two letters
    public String sol_2(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    // Manacher Algorithm
    // T = O(n)
    // S = O(n)
    public String sol_3(String s){
        String t = "$#";
        for(int i = 0; i < s.length(); ++i){
            t += s.charAt(i);
            t += "#";
        }
        System.out.println(t);
        int p[] = new int[t.length()];
        int mx = 0, id = 1, resLen = 0, resCenter = 0;
        for (int i = 1; i < t.length(); ++i) {
            p[i] = mx > i ? Math.min(p[2 * id - i], mx - i) : 1;
            while (i + p[i] < t.length() && i - p[i] >= 0){
                if (t.charAt(i + p[i]) == t.charAt(i - p[i])) {
                    ++p[i];
                }
                else{
                    break;
                }
            }
            if (mx < i + p[i]) {
                mx = i + p[i];
                id = i;
            }
            if (resLen < p[i]) {
                resLen = p[i];
                resCenter = i;
            }
        }
        return s.substring((resCenter - resLen) / 2,
                (resCenter - resLen) / 2 + resLen - 1);
    }

    static public void main(String arg[]){
        p5_Longest_Palindromic_Substring sol = new p5_Longest_Palindromic_Substring();
        String test = "abb";
        String re = sol.sol_3(test);
        System.out.println(re);
    }
}
