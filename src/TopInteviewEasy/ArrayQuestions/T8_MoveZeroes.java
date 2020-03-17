package TopInteviewEasy.ArrayQuestions;

class T8_MoveZeroes {
    public void moveZeroes(int[] nums) {
        if(nums.length <= 1){
            return;
        }
        
        int cur = 0;
        int scaned = 0;
        while(cur==0 && scaned < nums.length){
            if(nums[scaned] == 0){
                cur = scaned;
                break;
            }
            scaned++;
        }
        if(cur == nums.length -1){
            return;
        }
        else if(scaned == nums.length){ 
            return;
        }

        for (int i = cur; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[cur] = nums[i];
                nums[i] = 0;
                cur++;
            }
        }
        return;
    }

    static public void main(String arg[]){
        T8_MoveZeroes Sol = new T8_MoveZeroes();
        int[] nums = {2,1};
        Sol.moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

}