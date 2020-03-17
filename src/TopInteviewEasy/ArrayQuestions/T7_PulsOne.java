package TopInteviewEasy.ArrayQuestions;

class T7_PlusOne {
    public int[] plusOne(int[] digits) {
        if(digits.length == 1){
            if(digits[0] != 9){
                digits[0] = digits[0] + 1;
                return digits;
            }
            else{
                int[] res = new int[digits.length+1];
                res[0] = 1;
                res[1] = 0;
                return res;
            }
        }
        else{
            int tail = digits.length-1;
            boolean extrabit = false;
            for(;tail>=0;tail--){
                if(digits[tail] == 9){
                    digits[tail] = 0;
                    if(tail == 0){
                        extrabit = true;
                    }
                }
                else{
                    digits[tail] = digits[tail] + 1;
                    break;
                }
            }
            if(!extrabit){
                return digits;
            }
            else{
                int[] res = new int[digits.length + 1];
                res[0] = 1;
                for (int i = 1; i < res.length; i++) {
                    res[i] = 0;
                }
                return res;
            }
        }
    }
}