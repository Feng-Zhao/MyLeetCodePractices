
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p18_4Sum {
    public List<List<Integer>> sol_1(int[] nums, int target) {
        if(nums.length < 4){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        kSum(4,target,res,cur,nums,0,nums.length);
        return res;
    }

    public void kSum(int depth, int target, List<List<Integer>> result,
                     List<Integer> curPath,
                     int[]nums, int start, int end){
        if (depth == 2) {                        // 2 Sum
            while (start < end-1) {
                if      (nums[start] + nums[end-1] < target) start++;
                else if (nums[start] + nums[end-1] > target) end--;
                else {
                    result.add(new ArrayList<>(curPath));
                    result.get(result.size() - 1).addAll(Arrays.asList(nums[start], nums[end-1]));
                    start++; end--;
                    while (start < end && nums[start] == nums[start - 1]) start++;
                    while (start < end && nums[end] == nums[end + 1]) end--;
                }
            }
        }
        else if(depth > 2){
            for (int i = start; i < end - depth + 1; i++) {
                List<Integer> temp = new ArrayList<>(curPath);
                temp.add(nums[i]);
                if(i > 0 && nums[i-1] == nums[i]){}
                else {
                    kSum(depth - 1, target - nums[i], result, temp, nums,
                            i + 1, end);
                }
            }
        }
    }
    static public void main(String[] arg){
        p18_4Sum sol = new p18_4Sum();
        int[] test_n = {-1,0,-1,0,-2,2};
        int test_t = 0;
        List<List<Integer>> re = sol.sol_1(test_n, test_t);
        System.out.println(re.toString());
    }

}
