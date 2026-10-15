class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        int[] arr = new int[2];
        arr[0] = -1;
        arr[1] = -1;
        while(low<=high){
            int mid = low+((high-low)/2);
            if(nums[mid]==target){
                if(mid==0 || nums[mid-1]<nums[mid]){
                    arr[0] = mid;
                    break;
                }
                else{
                    high = mid-1;
                }
            }
            else if(nums[mid]<target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        low = 0;
        high = nums.length-1;
        while(low<=high){
            int mid = low+((high-low)/2);
            if(nums[mid]==target){
                if(mid==nums.length-1 || nums[mid+1]>nums[mid]){
                    arr[1] = mid;
                    break;
                }
                else{
                    low = mid+1;
                }
            }
            else if(nums[mid]<target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return arr;
    }
}