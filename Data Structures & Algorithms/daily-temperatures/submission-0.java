class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            int temperature = temperatures[i];
            int[] pair = {i, temperature};
            while (!stack.isEmpty() && temperature > stack.peek()[1]) {
                int[] prevPair = stack.pop();
                res[prevPair[0]] = i - prevPair[0];
            }
            stack.push(pair);
        }
        return res;
    }
}
