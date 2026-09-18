class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=nums.length-2;i>=0;i--){
            stack.push(nums[i]);
        }
        int[] ans = new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            if(stack.isEmpty()){
                ans[i] = -1;
            }
            else if(stack.peek()<=nums[i]){
                while(!stack.isEmpty()){
                    if(stack.peek()>nums[i])break;
                    stack.pop();
                }
                if(stack.isEmpty())ans[i]=-1;
                else ans[i]=stack.peek();
            }
            else{
                ans[i]=stack.peek();
            }
            stack.push(nums[i]);
        }
        return ans;
    }
}