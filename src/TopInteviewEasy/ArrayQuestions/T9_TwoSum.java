package TopInteviewEasy.ArrayQuestions;

import java.util.HashMap;

class T9_TwoSum {
    //brute force
    //just try all combinations
    //O(n^2)
    public int[] sol_1(int[] nums, int target) {
        int x;
        int y;
        for (x = 0; x < nums.length-1; x++){
            for(y = x+1 ; y < nums.length; y++){
                if (nums[x] + nums[y] == target){
                    return new int[]{x,y};
                }
            }
        }
        return null;
    }

    //use Map to store the first num
    //and use map.containsKey() method to check whether there are
    //num: b which b = target - a;
    public int[] sol_2(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int x = 0; x < nums.length; x++){
            map.put(nums[x],x);
        }
        for(int x = 0; x < nums.length; x++){
            int a = nums[x];
            int b = target - a;
            if(map.containsKey(b) && map.get(b) != x){
                return new int[]{x,map.get(b)};
            }
        }
        return null;
    }
    
}