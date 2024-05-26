package com.nicolascardia.matriz.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Stack;

@Service
public class RectangleService {

    public int maximalRectangle(List<List<Integer>> matrix) {
        if (matrix == null || matrix.isEmpty()) {
            return 0;
        }

        int lines = matrix.size();
        int columns = matrix.get(0).size();
        int[] heights = new int[columns];
        int maxArea = 0;

        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                heights[j] = (matrix.get(i).get(j) == 1) ? heights[j] + 1 : 0;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {
        Stack<Integer> indexStack = new Stack<>();
        int maxArea = 0;

        int[] extendedHeights = new int[heights.length + 1];
        System.arraycopy(heights, 0, extendedHeights, 0, heights.length);

        for (int i = 0; i < extendedHeights.length; i++) {
            while (!indexStack.isEmpty() && extendedHeights[i] < extendedHeights[indexStack.peek()]) {
                int height = extendedHeights[indexStack.pop()];
                int width = indexStack.isEmpty() ? i : i - indexStack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            indexStack.push(i);
        }

        return maxArea;
    }
}
