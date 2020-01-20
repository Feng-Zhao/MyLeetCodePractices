public class p27_Remove_Element {
    public int removeElement(int[] nums, int val) {
        int cur = 0;
        int count = 0;
        int scaned = 0;
        while(scaned < nums.length){
            if(nums[scaned] == val){
                scaned++;
                continue;
            }
            nums[cur] = nums[scaned];
            cur++;
            scaned++;
            count++;
        }
        return count;
    }
}
