public class p14_Longest_Common_Prefix {
    //scan in the vertical direction
    public String sol_1(String[] strs) {
        if(strs.length < 1){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        boolean stop = false;
        char c = '\0';
        int pos = 0;
        int maxl = 0;
        while(!stop){
            if(pos < strs[0].length()){
                c = strs[0].charAt(pos);
                for (int i = 0; i < strs.length; ++i){
                    if(pos == strs[i].length() || strs[i].charAt(pos)!= c){
                        stop = true;
                    }
                }
                ++pos;
            }
            else{
                stop = true;
            }
            if(!stop){
                ++maxl;
            }
        }
        String re = strs[0].substring(0,maxl);
        return re;
    }
    static public void main(String[] arg){
        p14_Longest_Common_Prefix sol = new p14_Longest_Common_Prefix();
        String[] test = {"firad","dirovcm","ficoasd"};
        String re = sol.sol_1(test);
        System.out.println(re);
    }
}
