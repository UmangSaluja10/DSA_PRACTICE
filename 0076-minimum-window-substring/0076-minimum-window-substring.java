class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        int[] counts = new int[256];
        int[] countt = new int[256];
        for (int i = 0; i < t.length(); i++) {
            countt[t.charAt(i)]++;
        }
        int left = 0, count = 0, min = Integer.MAX_VALUE, startIdx = 0;
        for (int right = 0; right < s.length(); right++) {
            char currChar = s.charAt(right);
            counts[currChar]++;
            if (countt[currChar] > 0 && counts[currChar] <= countt[currChar]) {
                count++;
            }
            while (count == t.length()) {
                int len = right - left + 1;
                if (len < min) {
                    min = len;
                    startIdx = left;
                }
                char startChar = s.charAt(left);
                counts[startChar]--;
                if (countt[startChar] > 0 && counts[startChar] < countt[startChar]) {
                    count--;
                }
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(startIdx, startIdx + min);
    }
}