package hello.web_shopping.service.review;

import hello.web_shopping.dto.review.ReviewReturnDto;

public interface ReviewService {

    ReviewReturnDto writeReview(String loginId, String itemName, String comment);
}
