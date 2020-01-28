package TopInteviewEasy.ArrayQuestions;

import java.util.*;

public class T3_Rotate_Array {
    public void rotate(int[] nums, int k) {
        if(nums.length < 2){
            return;
        }
        else if (k >= nums.length){
            rotate(nums,k-nums.length);
            return;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = nums.length-1; i >= nums.length-k; i--) {
            deque.addFirst(nums[i]);
        }
        for (int i = 0; i < nums.length-k; i++) {
            deque.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = deque.poll();
        }
        // for (int i = 0; i < nums.length; i++) {
        //     System.out.println(nums[i]);
        // }
    }
    static public void main(String[] args){
        T3_Rotate_Array Sol = new T3_Rotate_Array();
        int[] nums = {1,2,3,4,5,6,7};
        Sol.rotate(nums,3);
    }

}
