package hello.web_shopping.service.member;

import hello.web_shopping.dto.member.MemberJoinReturnDto;
import hello.web_shopping.dto.member.MemberRegisterDto;
import hello.web_shopping.entity.Member;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface MemberService {

    List<MemberJoinReturnDto> findAll();
    MemberJoinReturnDto join(MemberRegisterDto memberRegisterDto);

    MemberJoinReturnDto findByLoginId(String loginId);
}
