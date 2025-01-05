package hello.web_shopping.entity;

import hello.web_shopping.dto.member.MemberRegisterDto;
import hello.web_shopping.entity.embeddablePkg.AddressEmb;
import hello.web_shopping.entity.enumPkg.Grade;
import jakarta.persistence.*;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String loginId;
    private String nickname;
    private String email;
    private String password;
    private String phone;
    private LocalDateTime birth;
    @Enumerated(EnumType.STRING)
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

    public void createMember(MemberRegisterDto dto){
        this.loginId = dto.getLoginId();
        this.nickname = dto.getNickname();
        this.email = dto.getEmail();
        this.password = dto.getPassword();
        this.phone = dto.getPhone();
        this.birth = dto.getBirth();
        this.createdDate = LocalDateTime.now();
        this.updatedDate = createdDate;
        this.address = new AddressEmb(dto.getCity(), dto.getStreet(), dto.getZipcode());
        this.grade = Grade.GOOD;
    }

    public void createAdminMember() {
        this.loginId = "admin";
        this.nickname = "admin";
        this.email = "admin@admin.com";
        this.password = "1234";
        this.phone = "010-8888-8888";
        this.birth = LocalDateTime.now();
        this.createdDate = LocalDateTime.now();
        this.updatedDate = createdDate;
        this.address = new AddressEmb("Seoul", "Buk-gu", "GangNamGu");
        this.grade = Grade.GOOD;
    }
}
