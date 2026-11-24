class Solution {
    public int countDominantElements(int[] nums) {
        if(nums.length==1)return 1;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(i==0 && nums[i+1]<=nums[i])count++;
            else if(i==nums.length-1 && nums[i]>=nums[i-1])count++;
            else if(i>0 && i<nums.length-1 && 2L*nums[i]>=(long)(nums[i+1]+nums[i-1]))count++;
        }
        return count;
    }
}