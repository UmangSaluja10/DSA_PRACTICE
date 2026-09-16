class Solution {
    public boolean isValid(String s) {
        HashMap<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='[' || c=='{' || c=='('){
                stack.push(c);
            }else{
                if(!stack.isEmpty() && map.get(stack.peek())==c){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}