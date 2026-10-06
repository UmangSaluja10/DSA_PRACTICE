class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int  x = cardPoints.length-k;
        int left = 0, min = Integer.MAX_VALUE, sum = 0, overallSum = 0, ans = 0;
        for(int n : cardPoints){
            overallSum+=n;
        }
        for(int right = 0; right<cardPoints.length;right++){
            sum+=cardPoints[right];
            while(right-left+1>x){
                sum-=cardPoints[left];
                left++;
            }
            if(right-left+1==x){
                min = Math.min(min,sum);
            }
        }
        return overallSum-min;
    }
}