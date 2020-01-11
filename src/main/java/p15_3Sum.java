import sun.tools.tree.NewArrayExpression;

import java.util.*;

public class p15_3Sum {
    public List<List<Integer>> sol_1(int[] nums) {
        if(nums.length < 3){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        if(nums[0] > 0 || nums[nums.length-1] < 0){
            return new ArrayList<>();
        }
        //the below part is comes from shpolsky,
        //https://leetcode.com/problems/3sum/discuss/7380/Concise-O(N2)-Java-solution
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length-2; i++) {
            //remove repeated answer// each num could only be the sum once
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int lo = i+1, hi = nums.length-1, sum = 0 - nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo+1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi-1]) hi--;
                        lo++; hi--;
                    } else if (nums[lo] + nums[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }
    static public void main(String[] arg){
        p15_3Sum sol = new p15_3Sum();
        int[] test = {-1,0,1,2,-1,-4};
        List<List<Integer>> re = sol.sol_1(test);
        System.out.println(re.toString());
    }
}
