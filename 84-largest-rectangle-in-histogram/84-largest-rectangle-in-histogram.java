import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Bar> stack = new Stack<>();
        int max = 0;

        for (int i = 0; i <= heights.length; i++) {
            int current = (i == heights.length ? 0 : heights[i]);
            if(stack.isEmpty() || current >= stack.peek().height) {
                stack.push(new Bar(i, current));
                continue;
            }

            Bar tmp = stack.pop();
            max = Math.max(max, tmp.height * (stack.isEmpty() ? i : i - 1 - stack.peek().index));
            i--;
        }
        return max;
    }

    public class Bar {
        int index, height;
        public Bar(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
}