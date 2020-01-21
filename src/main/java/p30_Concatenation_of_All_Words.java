import java.util.HashMap;
import java.util.List;

public class p30_Concatenation_of_All_Words {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<Integer,String> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {

            map.put(i,words[i]);
        }
    }
}
