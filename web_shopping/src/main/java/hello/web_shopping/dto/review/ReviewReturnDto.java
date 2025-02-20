package hello.web_shopping.dto.review;

import hello.web_shopping.entity.Review;
import lombok.Data;

@Data
public class ReviewReturnDto {

    private String loginId;
    private String itemName;
    private String comment;

    public ReviewReturnDto(Review review) {
        this.loginId = review.getMember().getLoginId();
        this.itemName = review.getItem().getName();
        this.comment = review.getComment();
    }
}
