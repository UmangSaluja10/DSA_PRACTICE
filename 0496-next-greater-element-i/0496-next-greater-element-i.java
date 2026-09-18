class Solution {
    public static void nextGreater(int[] nums, HashMap<Integer,Integer> map){
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=nums.length-1;i>=0;i--){
            if(stack.isEmpty()){
                map.put(nums[i],-1);
                stack.push(nums[i]);
            }else if(stack.peek()<=nums[i]){
                while(!stack.isEmpty()){
                    if(stack.peek()>nums[i])break;
                    stack.pop();
                }
                if(stack.isEmpty())map.put(nums[i],-1);
                else map.put(nums[i],stack.peek());
                stack.push(nums[i]);
            }else{
                map.put(nums[i],stack.peek());
                stack.push(nums[i]);
            }
        }
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        nextGreater(nums2,map);
        int[] ans = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}