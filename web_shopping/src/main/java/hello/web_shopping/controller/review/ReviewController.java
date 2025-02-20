package hello.web_shopping.controller.review;

import hello.web_shopping.dto.review.ReviewReturnDto;
import hello.web_shopping.service.review.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/{itemName}")
    public ResponseEntity<ReviewReturnDto> writeReview(String loginId, @PathVariable String itemName, String comment){

        ReviewReturnDto returnDto = reviewService.writeReview(loginId, itemName, comment);
        return new ResponseEntity<>(returnDto, HttpStatus.OK);
    }
}
