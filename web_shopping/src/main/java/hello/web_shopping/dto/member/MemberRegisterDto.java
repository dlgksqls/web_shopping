package hello.web_shopping.dto.member;

import hello.web_shopping.entity.embeddablePkg.AddressEmb;
import hello.web_shopping.entity.enumPkg.Grade;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MemberRegisterDto {

    private String loginId;
    private String nickname;
    private String email;
    private String password;
    private String phone;
    private LocalDateTime birth;
    private String city, street, zipcode;
}
