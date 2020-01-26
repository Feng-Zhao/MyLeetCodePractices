package TopInteviewEasy.ArrayQuestions;

import java.util.Arrays;
import java.util.Map;

public class stockBS {
    public int maxProfit(int[] prices) {
        if(prices.length < 1){
            return 0;
        }
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] - prices[i-1] > 0){
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }

}
