class Solution {
    public String[] assignUmbrella(int[] rain) {
        int n = rain.length;
        String[] res = new String[rain.length];
        int countA=0, countB=0;
        for(int i=0;i<n;i++){
            boolean needA = (i<n-1) && (rain[i]==1 && rain[i+1]==1);
            boolean needB = (rain[i]==1);
            if(needA){
                if(countA<=countB){
                    res[i] = "Alice";
                    countA++;
                }else{
                    res[i] = "Bob";
                    countB++;
                }
            }
            else if(needB){
                res[i] = "Bob";
                countB++;
            }
            else{
                res[i] = "None";
            }
        }
        return res;
    }
}