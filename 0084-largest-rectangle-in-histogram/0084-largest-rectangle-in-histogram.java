class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Deque<Integer> positionStack = new ArrayDeque<>();
        Deque<Integer> heightStack = new ArrayDeque<>();
        int ind,i;
        for(i=0;i<n;i++){
            ind = i;
            if(i==0 || heights[i]>=heightStack.peek()){
                heightStack.push(heights[i]);
                positionStack.push(i);
            }
            else{
                while(!heightStack.isEmpty() && heightStack.peek()>heights[i]){
                    int h = heightStack.pop();
                    ind = positionStack.pop();
                    maxArea = Math.max(maxArea,h*(i-ind));
                }
                heightStack.push(heights[i]);
                positionStack.push(ind);
            }
        }
        while(!heightStack.isEmpty()){
                    int h = heightStack.pop();
                    ind = positionStack.pop();
                    maxArea = Math.max(maxArea,h*(i-ind));
                }
        return maxArea;
    }
}