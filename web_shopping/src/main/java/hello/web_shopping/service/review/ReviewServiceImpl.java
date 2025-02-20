package hello.web_shopping.service.review;

import hello.web_shopping.dto.review.ReviewReturnDto;
import hello.web_shopping.entity.Item;
import hello.web_shopping.entity.Member;
import hello.web_shopping.entity.Review;
import hello.web_shopping.repository.ItemRepository;
import hello.web_shopping.repository.MemberRepository;
import hello.web_shopping.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository reviewRepository;
    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public ReviewReturnDto writeReview(String loginId, String itemName, String comment) {
        Item reviewItem = itemRepository.findByName(itemName);
        Member reviewMember = memberRepository.findByLoginId(loginId);

        Review review = new Review();
        review.createReview(reviewItem, reviewMember, comment);

        reviewRepository.save(review);

        return new ReviewReturnDto(review);
    }
}

