class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low=0,high=nums.length-1;
        int[] arr = new int[2];
        arr[0] = arr[1] = -1;
        while(low<=high){
            int mid = low+((high-low)/2);
            if(nums[mid]==target && (mid==0 || nums[mid-1]!=target)){
                arr[0] = mid;
                break;
            }else if(nums[mid]<target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        low=0;
        high=nums.length-1;
        while(low<=high){
            int mid = low+((high-low)/2);
            if(nums[mid]==target && (mid==nums.length-1 || nums[mid+1]!=target)){
                arr[1] = mid;
                break;
            }else if(nums[mid]<=target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return arr;
    }
}