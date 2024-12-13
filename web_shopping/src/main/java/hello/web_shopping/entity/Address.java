package hello.web_shopping.entity;

import hello.web_shopping.entity.embeddablePkg.AddressEmb;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "address")
public class Address {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long address_id;

    @Embedded
    private AddressEmb address;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private String status;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}
