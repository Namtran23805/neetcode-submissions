class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] preprod = new int[nums.length];
        int[] suffprod = new int[nums.length];
        preprod[0] = nums[0];
        suffprod[0] = nums[n - 1];
        for (int i = 0; i < nums.length; i++) {
            if (i != 0) {
                preprod[i] = preprod[i - 1] * nums[i];
                suffprod[i] = suffprod[i - 1] * nums[n - 1 - i];
            }
        }
        int[] res = new int[nums.length];
        res[0] = suffprod[nums.length - 2];
        res[n - 1] = preprod[nums.length - 2];
        for (int i = 1; i < nums.length - 1; i++) {
            res[i] = preprod[i - 1] * suffprod[n - i - 2];
        }
        return res;

    }
}  
