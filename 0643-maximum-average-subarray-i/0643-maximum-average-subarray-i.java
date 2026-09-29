class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left=0, right=k;
        double sum=0; 
        double maxAvg=Integer.MIN_VALUE;
        for(int i=left;i<right;i++){
            sum += nums[i];
        }
        maxAvg=Math.max(maxAvg,sum/k);
        while(right<nums.length){
            sum = sum-nums[left++]+nums[right++];
            maxAvg = Math.max(maxAvg,sum/k);
        }
        return maxAvg;
    }
}