package pykube.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pykube.net.PykubeModel;
import pykube.repo.PykubeRepo;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private PykubeRepo reviewRepository;

    public List<PykubeModel> getAllReviews() {
        return reviewRepository.findAll();
    }

    public PykubeModel addReview(PykubeModel review) {
        return reviewRepository.save(review);
    }
}

