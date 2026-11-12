class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        if(nums.length==1)return 1;
        int count = 1;
        int maxInc = 0, maxDec =0;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]<nums[i]){
                count++;
            }else{
                count = 1;
            }
            maxInc = Math.max(maxInc,count);
        }
        count = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]>nums[i]){
                count++;
            }else{
                count = 1;
            }
            maxDec = Math.max(maxDec,count);
        }
        return Math.max(maxInc,maxDec);

    }
}