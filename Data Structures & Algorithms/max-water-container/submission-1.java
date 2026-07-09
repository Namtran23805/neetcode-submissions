class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int res = 0;
        int l = 0;
        int r = n-1;
        while (l < r) {
            int width = r - l;
            int height = Math.min(heights[l], heights[r]);
            int area = width * height;
            if (area > res) {
                res = area;
            }
            if (heights[l] <= heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
