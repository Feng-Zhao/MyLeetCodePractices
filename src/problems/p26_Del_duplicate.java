package problems;

public class p26_Del_duplicate {
    public int removeDuplicates(int[] nums) {
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
