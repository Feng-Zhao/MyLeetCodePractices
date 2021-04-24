package jianzhioffer;


public class P05_ReplaceSpace {
    // replace the ' ' with %20
    public String replaceSpace(String s) {
        return s.replaceAll(" ", "%20");
    }

    public String replaceSpace2(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' '){
                sb.append("%20");
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        P05_ReplaceSpace p = new P05_ReplaceSpace();
        String str = " hello  world ! ";
        System.out.println(p.replaceSpace2(str));
    }
}
