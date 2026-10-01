class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int x:nums){
            set.add(x);
        }
        int max = 0;
        for(Integer n:set){
            int count = 0;
            if(set.contains(n-1)){
                continue;
            }
            else{
                int x=0;
                while(set.contains(n+x)){
                    count++;
                    x++;
                }
                max = Math.max(max,count);
            }
        }
        return max;
    }
}