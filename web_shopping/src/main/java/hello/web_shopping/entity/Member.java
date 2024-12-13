package hello.web_shopping.entity;

import hello.web_shopping.entity.embeddablePkg.AddressEmb;
import hello.web_shopping.entity.enumPkg.Grade;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long member_id;
    private String username;
    private String nickname;
    private String email;
    private String password;
    private String phone;
    private LocalDateTime birth;
    @Enumerated(EnumType.STRING)
    @ColumnDefault("Good")
    private Grade grade;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    @Embedded
    private AddressEmb address;


    @OneToMany(mappedBy = "member")
    private List<Address> addressList = new ArrayList<>();
    @OneToMany(mappedBy = "member")
    private List<Order> orderList = new ArrayList<>();
    @OneToMany(mappedBy = "member")
    private List<Cart> cartList = new ArrayList<>();
    @OneToMany(mappedBy = "member")
    private List<Review> reviewList = new ArrayList<>();
}
