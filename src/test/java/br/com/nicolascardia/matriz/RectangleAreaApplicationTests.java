package com.nicolascardia.matriz;

import com.nicolascardia.matriz.service.RectangleService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = RectangleAreaApplication.class)
class RectangleAreaApplicationTests {

    private final RectangleService rectangleService = new RectangleService();

    @Test
    void contextLoads() {
    }

    @Test
    void testMaximalRectangle() {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(1, 0, 1, 0, 0),
                Arrays.asList(1, 0, 1, 1, 1),
                Arrays.asList(1, 1, 1, 1, 1),
                Arrays.asList(1, 0, 0, 1, 0)
        );
        int result = rectangleService.maximalRectangle(matrix);
        assertEquals(6, result, "The maximal rectangle area should be 6");
    }

    @Test
    void testMaximalRectangleEmpty() {
        List<List<Integer>> matrix = Arrays.asList();
        int result = rectangleService.maximalRectangle(matrix);
        assertEquals(0, result, "The maximal rectangle area for an empty matrix should be 0");
    }

    @Test
    void testMaximalRectangleSingleRow() {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(1, 1, 1, 1)
        );
        int result = rectangleService.maximalRectangle(matrix);
        assertEquals(4, result, "The maximal rectangle area should be 4 for a single lines of 1s");
    }

    @Test
    void testMaximalRectangleSingleColumn() {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(1),
                Arrays.asList(1),
                Arrays.asList(1)
        );
        int result = rectangleService.maximalRectangle(matrix);
        assertEquals(4, result, "The maximal rectangle area should be 4 for a single columns of 1s");
    }

    @Test
    void testMaximalRectangleAllZeros() {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(0, 0, 0, 0),
                Arrays.asList(0, 0, 0, 0),
                Arrays.asList(0, 0, 0, 0),
                Arrays.asList(0, 0, 0, 0)
        );
        int result = rectangleService.maximalRectangle(matrix);
        assertEquals(0, result, "The maximal rectangle area should be 0 for a matrix of all 0s");
    }

    @Test
    void testMaximalRectangleMixed() {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(0, 1, 1, 0),
                Arrays.asList(1, 1, 1, 0),
                Arrays.asList(0, 1, 1, 1),
                Arrays.asList(1, 1, 1, 1)
        );
        int result = rectangleService.maximalRectangle(matrix);
        assertEquals(8, result, "The maximal rectangle area should be 8 for the mixed matrix");
    }
}
