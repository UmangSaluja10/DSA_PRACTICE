class Solution {
    public long minCost(int[] nums) {
        int n = nums.length;
        long min = Long.MAX_VALUE;
        int i = 0;
        while(i<n){
            int start = i;
            int x = nums[i];
            while(i<n &&nums[i]==x){
                i++;
            }
            int end = i-1;
            long preSum = 0;
            long sufSum = 0;
            if(start!=0){
                if(start>=n-1)continue;
                preSum = (long)start*x;
            }
            if(end!=n-1){
                if(end==0)continue;
                sufSum = (long) (n-end-1)*x;
            }
            long cost = preSum+sufSum;
            min = Math.min(min,cost);
        }
        return min;
    }
}