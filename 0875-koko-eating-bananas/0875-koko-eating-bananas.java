class Solution {
    public boolean check(int[] arr, int mid, int h){
        long sum = 0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i]/mid;
            if((arr[i]%mid)!=0)sum+=1;
        }
        return sum<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max = Arrays.stream(piles).max().getAsInt();
        int low = 1, high = max, ans = -1;
        while(low<=high){
            int mid = low+((high-low)/2);
            if(check(piles,mid,h)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}