package TopInteviewEasy.ArrayQuestions;

public class T1_RemoveDuplicates {
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

    static public void main(String arg[]){
        T1_RemoveDuplicates Sol = new T1_RemoveDuplicates();
        int[] nums = {1,2,3,4,4,5,5,6,6,7};
        System.out.println(Sol.sol_1(nums));
    }
}
