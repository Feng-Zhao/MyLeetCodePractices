import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class p665_non_decreasing_array {
    final Logger logger = LoggerFactory.getLogger(p665_non_decreasing_array.class);

    boolean sol_1(int[] nums) {
        if(nums.length < 3)
            return true;

        int upCount = 0, downCount = 0;
        int upMax = nums[0], downMin = nums[nums.length-1];

        for(int i = 1, j = nums.length - 2; i < nums.length && j > -1; ++i, --j) {
            if(nums[i] < upMax)
                ++upCount;

            if(nums[j] > downMin)
                ++downCount;

            if(upCount > 1 && downCount > 1) {
                logger.debug("upCount:{}",upCount);
                logger.debug("upCount:{}",downCount);
                return false;
            }

            upMax = Math.max(upMax, nums[i]);
            downMin = Math.min(downMin, nums[j]);
        }
        logger.debug("upCount:{}",upCount);
        logger.debug("upCount:{}",downCount);
        return true;
    }

    static public void main(String[] arg){
        p665_non_decreasing_array sol =
                new p665_non_decreasing_array();
        int[] test = {1,4,5,3,4};
        boolean re = sol.sol_1(test);
        System.out.println(re);
    }
}
