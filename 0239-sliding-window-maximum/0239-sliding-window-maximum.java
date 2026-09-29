class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue =  new ArrayDeque<>();
        int[] arr = new int[nums.length-k+1];
        int in=0;
        for(int i=0;i<nums.length;i++){
            while(!queue.isEmpty() && queue.peekFirst()<=i-k){
                queue.removeFirst();    
            }
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.removeLast();
            }
            queue.addLast(i);
            if (i >= k - 1) {
                arr[in++] = nums[queue.peekFirst()];
            }
        }
        return arr;
    }
}