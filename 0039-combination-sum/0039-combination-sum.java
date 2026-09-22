class Solution {
    public static void Sum(int start, int[] candidates, int remaining, List<Integer> current, List<List<Integer>> result){
        if(remaining == 0){
            result.add(new ArrayList<>(current));
            return;
        }
        if(remaining<0)return;
        for(int i=start;i<candidates.length;i++){
            current.add(candidates[i]);
            Sum(i,candidates,remaining-candidates[i],current,result);
            current.remove(current.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Sum(0,candidates, target, new ArrayList<>(), result);
        return result;
    }
}