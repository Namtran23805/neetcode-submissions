class Solution {
    public boolean isHappy(int n) {
        int fast = sumOfSquares(n);
        int slow = n;
        while (slow != fast) {
            fast = sumOfSquares(fast);
            fast = sumOfSquares(fast);
            slow = sumOfSquares(slow);
        }
        return fast == 1;

    }

    public int sumOfSquares(int n) {
        if (n < 0) {
            return -1;
        } else if (n < 10) {
            return n*n;
        }
        int last_digit = n % 10;
        return last_digit * last_digit + sumOfSquares(n / 10);
    }
}
