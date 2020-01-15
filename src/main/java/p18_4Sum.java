
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
        kSum(4,target,res,cur,nums,0);
        return res;
    }

    public void kSum(int depth, int target, List<List<Integer>> result,
                     List<Integer> curPath,
                     int[]nums, int start){
        int max = nums[nums.length - 1];
        if (nums[start] * depth > target || max * depth < target) return;
        //the minimum size of this problem
        if (depth == 2) {                        // 2 Sum
            int left = start;
            int right = nums.length - 1;
            //search answers
            while (left < right) {
                if      (nums[left] + nums[right] < target) left++;
                else if (nums[left] + nums[right] > target) right--;
                else {
                    result.add(new ArrayList<>(curPath));
                    result.get(result.size() - 1).addAll(Arrays.asList(nums[left], nums[right]));
                    left++; right--;
                    //remove the repeat combinations
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                }
            }
        }
        else{
            //backtracking
            for (int i = start; i < nums.length - depth + 1; i++) {
                //break if once we found this path does not contain an answer.
                if (i > start && nums[i] == nums[i - 1]) continue;
                if (nums[i] + max * (depth - 1) < target) continue;
                if (nums[i] * depth > target) break;
                if (nums[i] * depth == target) {
                    if (nums[i + depth - 1] == nums[i]) {
                        result.add(new ArrayList<>(curPath));
                        List<Integer> temp = new ArrayList<>();
                        for (int x = 0; x < depth; x++) temp.add(nums[i]);
                        result.get(result.size() - 1).addAll(temp);    // Add result immediately.
                    }
                    break;
                }
                curPath.add(nums[i]);
                kSum(depth - 1, target - nums[i], result, curPath, nums,
                            i + 1);
                //back to the last state
                curPath.remove(curPath.size()-1);
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
