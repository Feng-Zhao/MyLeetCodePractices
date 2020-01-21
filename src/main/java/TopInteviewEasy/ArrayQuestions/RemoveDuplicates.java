package TopInteviewEasy.ArrayQuestions;

public class RemoveDuplicates {
    public int sol_1(int[] nums) {
        if(nums.length < 2){
            return nums.length;
        }
        int cur = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[cur] != nums[i]){
                cur++;
                nums[cur] = nums[i];
            }
        }
        return cur+1;
    }
}
