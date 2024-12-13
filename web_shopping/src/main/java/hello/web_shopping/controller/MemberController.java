package hello.web_shopping.controller;

import hello.web_shopping.dto.member.MemberJoinReturnDto;
import hello.web_shopping.dto.member.MemberRegisterDto;
import hello.web_shopping.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("")
    public ResponseEntity<List<MemberJoinReturnDto>> allMember() {

        List<MemberJoinReturnDto> returnDto = memberService.findAll();
        return new ResponseEntity<>(returnDto, HttpStatus.ACCEPTED);
    }

    @PostMapping("")
    public ResponseEntity<MemberJoinReturnDto> saveMember(MemberRegisterDto dto){

        MemberJoinReturnDto returnDto = memberService.join(dto);
        return new ResponseEntity<>(returnDto, HttpStatus.CREATED);
    }
}
