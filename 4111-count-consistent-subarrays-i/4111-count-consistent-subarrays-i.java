class Solution {
    public int countConsistent(int[] nums) {
        int count = nums.length;
        for(int i=0;i<nums.length;i++){
            int bitAnd = nums[i];
            int min = nums[i];
            for(int j=i+1;j<nums.length;j++){
                bitAnd &= nums[j];
                min = Math.min(min,nums[j]);
                if(bitAnd == min){
                    count++;
                }
            }
        }
        return count;
    }
}