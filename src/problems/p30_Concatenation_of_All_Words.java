package problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class p30_Concatenation_of_All_Words {
    public List<Integer> findSubstring(String s, String[] words) {
        if(words.length == 0){
            return null;
        }
        int sizeOfWords = words.length;
        int lenOfWord = words[0].length();
        if(s.length() < sizeOfWords * lenOfWord){
            return null;
        }
        Map<String,Integer> words2prime = new HashMap<>();
        for (int i = 1; i <= words.length; i++) {
            words2prime.put(words[i], thPrime(i));
        }

        for (int i = 0; i < s.length()-sizeOfWords*lenOfWord; i++) {
            String firstSub = s.substring(i, i + lenOfWord);
            if(words2prime.containsKey(firstSub)){
                
            }
        }
        return null;
    }

    private int thPrime(int n){
        //TODO
        return n;
    }
}
