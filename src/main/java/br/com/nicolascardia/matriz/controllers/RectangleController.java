package com.nicolascardia.matriz.controllers;

import com.nicolascardia.matriz.model.MatrixInput;
import com.nicolascardia.matriz.service.RectangleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rectangle")
public class RectangleController {

    @Autowired
    private RectangleService rectangleService;

    @PostMapping
    public ResponseEntity<Integer> getMaxRectangleArea(@RequestBody MatrixInput matrixInput) {
        int area = rectangleService.maximalRectangle(matrixInput.getMatrix());
        return ResponseEntity.ok(area);
    }
}
