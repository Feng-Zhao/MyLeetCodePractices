package problems;

public class p12_Integer_to_Roman {
    public String sol_1(int num) {
        String re = "";

        //M 1000
        while(num/1000 > 0){
            re += "M";
            num -= 1000;
        }
        if(num % 1000 > 899){
            re += "CM";
            num -= 900;
        }
        //D 500
        while(num/500 != 0){
            re += "D";
            num -= 500;
        }
        if(num % 500 > 399){
            re += "CD";
            num -= 400;
        }
        //C 100
        while(num/100 != 0){
            re += "C";
            num -= 100;
        }
        if(num % 100 > 89){
            re += "XC";
            num -= 90;
        }
        //L 50
        while(num/50 != 0){
            re += "L";
            num -= 500;
        }
        if(num % 50 > 39){
            re += "XL";
            num -= 40;
        }
        while (num/10 != 0){
            re += "X";
            num -= 10;
        }
        if(num % 10 == 9){
            re += "IX";
            num -= 9;
        }
        while(num/5 != 0){
            re += "V";
            num -= 5;
        }
        if(num % 5 == 4){
            re += "IV";
            num -= 4;
        }
        while(num != 0){
            re += "I";
            num -= 1;
        }
        return re;
    }
    public String sol_2(int num) {
        String s = Integer.toString(num);
        String re = "";
        for(int i = 0; i < s.length(); ++i){
            double base = Math.pow(10,i+1);
            double cur = num % base;
            if(cur == 0.4 * base || cur == 0.9 * base) {
                re = doubleLetter(cur) + re;
                num -= cur;
            }
            else{
                re = oneLetter(cur, base) + re;
                num -= cur;
            }
        }
        return re;
    }

    private String oneLetter(double x, double base){
        String[] symbol = {"I","V","X","L","C","D","M"};
        int pos = 2 * (int)(Math.log10(base)-1);
        String re = "";
        if (x >= 0.5 * base){
            re += symbol[pos + 1];
            x -= 0.5 * base;
        }
        for(int i = 0; i < x/(base/10); i++){
            re += symbol[pos];
        }
        return re;
    }
    private String doubleLetter(double x)
    {
        switch ((int)x){
            case 4: return "IV";
            case 9: return "IX";
            case 40: return "XL";
            case 90: return "XC";
            case 400: return "CD";
            case 900: return "CM";
            default:return "";
        }
    }
    static public void main(String[] arg){
        p12_Integer_to_Roman sol = new p12_Integer_to_Roman();
        int test = 1994;
        String re = sol.sol_2(test);
        System.out.println(re);
    }
}

//    Symbol       Value
//        I             1
//        V             5
//        X             10
//        L             50
//        C             100
//        D             500
//        M             1000

//        I can be placed before V (5) and X (10) to make 4 and 9.
//        X can be placed before L (50) and C (100) to make 40 and 90.
//        C can be placed before D (500) and M (1000) to make 400 and 900.