package hello.web_shopping.service.member;

import hello.web_shopping.dto.member.MemberJoinReturnDto;
import hello.web_shopping.dto.member.MemberRegisterDto;

import java.util.List;

public interface MemberService {

    List<MemberJoinReturnDto> findAll();
    MemberJoinReturnDto join(MemberRegisterDto memberRegisterDto);
}
