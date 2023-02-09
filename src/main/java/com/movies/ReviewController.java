package com.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @CrossOrigin(origins = "http://localhost:3000/Reviews")
    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String,String> payload){
        return new ResponseEntity<>(reviewService.createReview(payload.get("reviewBody"),payload.get("imdbId")), HttpStatus.OK);
    }
}
