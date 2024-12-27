package hello.web_shopping.controller.member;

import hello.web_shopping.dto.member.MemberJoinReturnDto;
import hello.web_shopping.dto.member.MemberRegisterDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("member")
public interface MemberControllerAPI {

    ResponseEntity<List<MemberJoinReturnDto>> allMember();

    ResponseEntity<MemberJoinReturnDto> saveMember(MemberRegisterDto dto);
}
