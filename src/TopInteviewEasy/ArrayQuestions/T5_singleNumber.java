package TopInteviewEasy.ArrayQuestions;
import java.util.HashSet;
import java.util.Set;

public class T5_singleNumber {
    //delete the Exception part;
    //the problem has an assumption
    public int singleNumber(int[] nums) throws Exception{

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])){
                set.remove(nums[i]);
            }
            else{
                set.add(nums[i]);
            }
        }
        if(set.iterator().hasNext()){
            return set.iterator().next();
        }
        else{
            throw  new Exception("not found");
        }
    }
    static public void main(String[] args){
        T5_singleNumber Sol = new T5_singleNumber();
        int[] nums = {1,2,3,4,1,3,2};
        try{
            System.out.println(Sol.singleNumber(nums));
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
