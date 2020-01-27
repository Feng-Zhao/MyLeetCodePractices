package TopInteviewEasy.ArrayQuestions;

import java.util.*;

public class T3_Rotate_Array {
    public void rotate(int[] nums, int k) {
        Queue<Integer> newList = new ArrayDeque<>();
        for (int i = nums.length-1; i >= nums.length-k; i--) {
            newList.add(nums[i]);
        }
        for (int i = 0; i < nums.length-k; i++) {
            newList.add(nums[i]);
        }
//        nums = newList.toArray(new int[0]);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
    static public void main(String arg[]){
        T3_Rotate_Array Sol = new T3_Rotate_Array();
        int[] nums = {1,2,3,4,5,6,7};
        Sol.rotate(nums,3);
    }

}
