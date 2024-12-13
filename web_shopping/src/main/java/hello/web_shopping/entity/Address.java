package hello.web_shopping.entity;

import hello.web_shopping.entity.embeddablePkg.AddressEmb;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Address {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private AddressEmb addressHistory;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private String status;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}
