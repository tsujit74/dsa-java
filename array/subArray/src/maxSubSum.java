public class maxSubSum {
    public static void bruteForce(int num[]){
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0;i < num.length;i++){
            int st = i;
            for (int j = i;j < num.length;j++){
                int end = j;
                currSum = 0;
                for (int k = st;k<=end;k++){
                    currSum += num[k];
                }
                System.out.println(currSum);
                if (maxSum <= currSum){
                    maxSum = currSum;
                }
            }
        }
        System.out.println("In brute force method");
        System.out.println("Max Sum: "+ maxSum);
    }

    // Prefix sum

    public static void prefixSum(int num[]){
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[num.length];
        prefix[0] = num[0];

        for (int i = 1;i<prefix.length;i++){
            prefix[i] = prefix[i-1] + num[i];
        }

        for (int i = 0;i<num.length;i++){
            int st = i;
            for (int j = i;j<num.length;j++){
                int end = j;
                currSum = st == 0 ? prefix[end]:prefix[end] - prefix[st-1];
                if (maxSum<=currSum){
                    maxSum = currSum;
                }
            }
        }
        System.out.println("In prefix method");
        System.out.println("Max sum: "+maxSum);
    }

    //KADANE'S
    public static void kadanes(int num[]){
        int ms = Integer.MIN_VALUE;
        int cs = 0;
        for (int i = 0;i<num.length;i++){
            cs = cs + num[i];
            if (cs<0){
                cs = 0;
            }
            ms = Math.max(cs,ms);
        }
        System.out.println("In kadane's mathod");
        System.out.println("Max sub "+ms);
    }

    //Trapping Water

    public static int trappedWater(int height[]){
        int n = height.length;
        int leftMax[] = new int[n];
        leftMax[0] = height[0];

        for(int i = 1;i<n;i++){
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }

        int rightMax[] = new int[n];
        rightMax[n-1] = height[n-1];
        
        for(int i=n-2;i>=0;i--){
            rightMax[i]= Math.max(height[i], rightMax[i+1]);
        }

        int trappedWater = 0;
        for(int i = 0;i<n;i++){
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trappedWater+=waterLevel-height[i];
        }
        return trappedWater;
    }

    //BUY and SELL STOCK

    public static int buyAndSellStock(int prices[]){
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit  = 0;

        for(int i = 0;i<prices.length;i++){
            if (buyPrice<prices[i]) {
                int profit = prices[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            }else{
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int prices[] = {7,1,5,3,6,4};
        //kadanes(num);
        //System.out.println(trappedWater(num));
        System.out.println(buyAndSellStock(prices));
    }
}
