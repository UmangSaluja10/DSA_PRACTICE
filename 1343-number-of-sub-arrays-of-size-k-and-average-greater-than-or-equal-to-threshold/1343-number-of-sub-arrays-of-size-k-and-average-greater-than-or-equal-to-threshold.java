class Solution {
    public int numOfSubarrays(int[] nums, int k, int threshold) {
        int left=0, right=k;
        int sum=0; 
        int count = 0;
        for(int i=left;i<right;i++){
            sum += nums[i];
        }
        if(sum/k>=threshold)count++;
        while(right<nums.length){
            sum = sum-nums[left++]+nums[right++];
            if(sum/k>=threshold)count++;
        }
        return count;
    }
}