package hello.web_shopping.controller.member;

import hello.web_shopping.dto.member.MemberJoinReturnDto;
import hello.web_shopping.dto.member.MemberRegisterDto;
import hello.web_shopping.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberControllerAPIImpl implements MemberControllerAPI {

    private final MemberService memberService;


    @GetMapping("")
    @Override
    public ResponseEntity<List<MemberJoinReturnDto>> allMember() {
        List<MemberJoinReturnDto> returnDto = memberService.findAll();
        return new ResponseEntity<>(returnDto, HttpStatus.ACCEPTED);
    }

    @PostMapping("")
    @Override
    public ResponseEntity<MemberJoinReturnDto> saveMember(MemberRegisterDto dto) {
        MemberJoinReturnDto returnDto = memberService.join(dto);
        return new ResponseEntity<>(returnDto, HttpStatus.CREATED);
    }
}
