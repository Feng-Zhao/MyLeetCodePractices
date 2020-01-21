
public class p11_Container_With_Most_Water {
    //Brute Force O(n^2)
    public int sol_1(int[] height) {
        int max = 0;
        for(int i = 0; i < height.length; i++){
            for(int j = i; j < height.length; j++){
                max = Math.max((j - i) * Math.min(height[i], height[j]), max);
            }
        }
        return max;
    }

    //from two side to the center,
    //each time, we reserve the higher wall
    //and compare the maxarea with the new area
    public int sol_2(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            maxArea = Math.max(maxArea, (j-i) * Math.min(height[i], height[j]));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }
    static public void main(String[] arg){
        p11_Container_With_Most_Water sol = new p11_Container_With_Most_Water();
        int[] test = {1,2};
        int re = sol.sol_2(test);
        System.out.println(re);
    }
}
