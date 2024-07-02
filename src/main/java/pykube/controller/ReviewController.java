package pykube.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pykube.net.PykubeModel;
import pykube.service.ReviewService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/reviews")
    public List<PykubeModel> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @PostMapping("/reviews")
    public PykubeModel addReview(@RequestBody PykubeModel review) {
        return reviewService.addReview(review);
    }
}
