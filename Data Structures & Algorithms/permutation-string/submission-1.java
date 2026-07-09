class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int l = 0;
        int r = s1.length() - 1;
        HashMap<Character, Integer> count1 = new HashMap<>();
        for (char c: s1.toCharArray()) {
            count1.put(c, count1.getOrDefault(c,0)+1);
        }
        while(r < s2.length()) {
            HashMap<Character, Integer> counts = new HashMap<>();
            for (int i = 0; i < s1.length(); i++) {
                counts.put(s2.charAt(l+i), counts.getOrDefault(s2.charAt(l+i), 0) + 1);
            }
            if (counts.equals(count1)) {
                return true;
            } else {
                l++;
                r++;
            }
        }
        return false;
        
    }
}
