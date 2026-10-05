class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int n = Collections.max(map.values());
        ArrayList<Integer>[] buckets = (ArrayList<Integer>[]) new ArrayList[n+1];
        for(int i=0;i<buckets.length;i++){
            buckets[i] = new ArrayList<>();
        }
        map.forEach((key, value) ->{
            buckets[value].add(key);
        });
        int[] ans = new int[k];
        int index = 0;
        for(int i=n;i>=0 && index<k;i--){
            for(int x : buckets[i]){
                ans[index++] = x;
                if(index == k){
                    break;
                }
            }
        }
        return ans;
    }
}