import java.util.ArrayList;
import java.util.List;

public class p22_Generate_Parentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesis(n,res,"",0);
        return res;
    }

    public void generateParenthesis(int n, List<String> result,
                                            String cur, int unpaired) {
        if(n == 0 && unpaired == 0){
            result.add(cur);
        }
        else if(n == 0){
            generateParenthesis(n, result, cur+")", unpaired-1);
        }
        else if(unpaired == 0){
            generateParenthesis(n-1, result, cur+"(", unpaired+1);
        }
        else{
            generateParenthesis(n-1, result, cur+"(", unpaired+1);
            generateParenthesis(n, result, cur+")", unpaired-1);
        }
    }

    static public void main(String[] arg){
        p22_Generate_Parentheses sol = new p22_Generate_Parentheses();
        int test = 3;
        List<String> res = sol.generateParenthesis(test);
        System.out.println(res.toString());
    }
}
