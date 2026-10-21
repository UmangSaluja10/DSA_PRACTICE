class Solution {
    public boolean check(int[] nums, int k, int d){
        int cap = 0;
        int x = 1;
        for(int n: nums){
            if(cap+n>k){
                x++;
                cap=n;
            }else{
                cap+=n;
            }
        }
        return x<=d;
    }
    public int shipWithinDays(int[] weights, int days) {
        int high = 0;
        for(int i=0;i<weights.length;i++){
            high+=weights[i];
        }
        int ans = -1;
        int low = Arrays.stream(weights).max().getAsInt();
        while(low<=high){
            int mid = low+((high-low)/2);
            if(check(weights,mid,days)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
}