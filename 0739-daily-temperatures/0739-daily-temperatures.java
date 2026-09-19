class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[n];
        for(int i=n-1;i>=0;i--){
            if(stack.isEmpty()){
                ans[i] = 0;
            }
            else if(temperatures[stack.peek()]>temperatures[i]){
                ans[i] = stack.peek()-i;
            }
            else{
                while(!stack.isEmpty()){
                    if(temperatures[stack.peek()]>temperatures[i])break;
                    stack.pop();
                }
                if(stack.isEmpty())ans[i]=0;
                else ans[i] = stack.peek()-i;
            }
            stack.push(i);
        }
        return ans;
    }
}