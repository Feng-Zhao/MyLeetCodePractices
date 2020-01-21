package problems;

import java.util.Arrays;

public class p16_3Sum_Closest {
    //Brute Force
    public int sol_1(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int result = 0;
        for(int i = 0; i < nums.length-2; ++i){
            for(int j = i + 1; j < nums.length-1; ++j){
                for (int k = j + 1; k < nums.length; ++k){
                    int sum = nums[i] + nums[j] + nums[k];
                    if(Math.abs(target - sum) < min){
                        min = Math.abs(target - sum);
                        result = sum;
                    }
                }
            }
        }
        return result;
    }

    //sort then search
    public int sol_2(int[] nums, int target) {
        if(nums.length == 3){
            return nums[0] + nums[1] + nums[2];
        }
        int min_dis = Integer.MAX_VALUE;
        int result = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; ++i){
            int start = i + 1;
            int end = nums.length-1;
            while(start < end){
                int sum = nums[i] + nums[start] + nums[end];
                int dis = target - sum;
                if(Math.abs(dis) < min_dis){
                    result = sum;
                    min_dis = Math.abs(dis);
                }
                if(dis > 0){
                    start++;
                }
                else if (dis < 0){
                    end--;
                }
                else if(dis == 0){
                    return sum;
                }
            }
        }
        return result;
    }
    static public void main(String[] arg){
        p16_3Sum_Closest sol = new p16_3Sum_Closest();
        int[] test_n = {-1,2,1,-4};
        int test_t = 1;
        int re = sol.sol_2(test_n, test_t);
        System.out.println(re);
    }
}
