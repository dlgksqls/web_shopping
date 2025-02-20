package hello.web_shopping.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;
//    private String image;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private Member member;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "itemId")
    private Item item;

    public void createReview(Item reviewItem, Member reviewMember, String comment) {
        this.item = reviewItem;
        this.member = reviewMember;
        this.comment = comment;
        this.createdDate = LocalDateTime.now();

        item.addReview(this);
    }
}
