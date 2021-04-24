package jianzhioffer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P03_RepeatNumber{
    // constrain nums[n] = [0,n-1],   n = [2,10000]
    public static int findRepeatNumber(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++){
            while (nums[i] != nums[nums[i]]){
                temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
            if (i != nums[i]){
                return nums[i];
            }
        }
        return -1;
    }

    public static int findRepeatNumber2(int[] nums) {
        Set<Integer> dic = new HashSet<>();
        for(int num : nums) {
            if(dic.contains(num)) return num;
            dic.add(num);
        }
        return -1;
    }

    public static int findRepeatNumber3(int[] nums){
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i+1]){
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 3};
        System.out.println(findRepeatNumber2(nums));
    }
}