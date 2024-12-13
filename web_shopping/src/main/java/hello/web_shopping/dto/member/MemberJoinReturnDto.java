package hello.web_shopping.dto.member;

import hello.web_shopping.entity.Member;
import hello.web_shopping.entity.embeddablePkg.AddressEmb;
import hello.web_shopping.entity.enumPkg.Grade;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MemberJoinReturnDto {

    private String loginId;
    private LocalDateTime createdDate;
    private String address;
    private String grade;

    public MemberJoinReturnDto(Member member) {
        this.loginId = member.getLoginId();
        this.createdDate = member.getCreatedDate();
        this.address = member.getAddress().toString();
        this.grade = member.getGrade().toString();
    }
}
