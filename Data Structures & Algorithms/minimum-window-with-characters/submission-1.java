class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) {
            return "";
        }
        HashMap<Character, Integer> countT = new HashMap<>();
        HashMap<Character, Integer> countWindow = new HashMap<>();
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;

        for (char c: t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            countWindow.put(s.charAt(r), countWindow.getOrDefault(s.charAt(r), 0) + 1);
            while (true) {
                if (compareMaps(countT, countWindow)) {
                    if ((r - l + 1) < resLen) {
                        resLen = r - l + 1;
                        res[0] = l;
                        res[1] = r;
                    }
                    countWindow.put(s.charAt(l), countWindow.getOrDefault(s.charAt(l), 0) - 1);
                    l++;
                } else {break;}
            }
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
    public static boolean compareMaps(Map<Character, Integer> mapA, Map<Character, Integer> mapB) {
        for (Map.Entry<Character, Integer> entry : mapA.entrySet()) {
            char key = entry.getKey();
            
            // Condition 1: B must contain the key
            if (!mapB.containsKey(key)) {
                return false;
            }
            
            // Condition 2: B's value must be >= A's value
            if (mapB.get(key) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
