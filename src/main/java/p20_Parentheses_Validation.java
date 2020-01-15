import java.sql.Statement;
import java.util.*;

public class p20_Parentheses_Validation {
    public boolean sol_1(String s) {
        List<Character> lefts = new ArrayList<Character>() {{
            add('(');
            add('[');
            add('{');
        }};
        Map<Character,Character> pair = new HashMap<Character, Character>() {{
            put(')','(');
            put(']','[');
            put('}','{');
        }};
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (lefts.contains(s.charAt(i))) {
                stack.push(s.charAt(i));
            }
            else{
                if(stack.empty()){
                    return false;
                }
                if(stack.peek() == pair.get(s.charAt(i))){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
        }
        if(stack.empty()){
            return true;
        }
        return false;
    }
    //a shorter format
    //comes from https://leetcode.com/problems/valid-parentheses/discuss/9178/Short-java-solution
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}