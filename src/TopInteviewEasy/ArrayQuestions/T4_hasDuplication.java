package TopInteviewEasy.ArrayQuestions;

import java.util.*;

public class T4_hasDuplication {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length < 2){
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        if(set.size() == nums.length){
            return false;
        }
        else{
            return true;
        }
    }
    static public void main(String[] args){
        T4_hasDuplication Sol = new T4_hasDuplication();
        int[] nums = {1,2,3,4,1};
        System.out.println(Sol.containsDuplicate(nums));
    }
}
