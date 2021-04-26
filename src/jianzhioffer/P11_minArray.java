package jianzhioffer;

public class P11_minArray {
    public int minArray(int[] numbers){
        if(numbers == null || 0 == numbers.length ){
            throw new RuntimeException();
        }

        for(int i=0; i<numbers.length-1; i++)
        {
           if(numbers[i]>numbers[i+1])
               return numbers[i+1];
        }
           return numbers[0];
    }
    public int minArray2(int[] numbers) {
        if(numbers == null || 0 == numbers.length ){
            throw new RuntimeException();
        }

        int left = 0;
        int right = numbers.length - 1; 
        
        if(numbers[left] < numbers[right]){
            return numbers[left];
        }
        else{
            while(left < right ){
                int mid = left + (right - left) / 2;
                if(numbers[mid] > numbers[right]){
                    left = mid + 1;
                }
                else if(numbers[mid] < numbers[right]){
                    right = mid;
                }
                else{
                    right--;
                }
            }
            return numbers[left];
        }
    }

    public static void main(String[] args) {
        P11_minArray p11 = new P11_minArray();
        int[] array = {4,4,5,5,6,6,6,1,2,3,4};
        System.out.println(p11.minArray2(array));
    }
}
