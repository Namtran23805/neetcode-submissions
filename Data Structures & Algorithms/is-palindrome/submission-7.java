class Solution {
    public boolean isPalindrome(String s) {
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "");
        int head = 0;
        int tail = cleaned.length() - 1;
        while (head < tail) {
            char left = Character.toLowerCase(cleaned.charAt(head));
            char right = Character.toLowerCase(cleaned.charAt(tail));
            if(left!=right) {
                return false;
            }
            head++;
            tail--;
        }
        return true;

    }
}
