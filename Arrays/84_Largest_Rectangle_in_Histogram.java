class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int max = 0;
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i <= n; i++) {
            int h = i == n ? 0 : heights[i];

            while (!s.isEmpty() && h < heights[s.peek()]) {
                int currHeight = heights[s.pop()];
                int prevIdx = s.isEmpty() ? -1 : s.peek();
                int area = currHeight * (i - prevIdx - 1);
                max = Math.max(max, area);
            }

            s.push(i);
        }

        return max;
    }
}
