package hello.web_shopping.service.member;

import hello.web_shopping.dto.member.MemberJoinReturnDto;
import hello.web_shopping.dto.member.MemberRegisterDto;
import hello.web_shopping.entity.Member;
import hello.web_shopping.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public List<MemberJoinReturnDto> findAll() {
        List<Member> allMember = memberRepository.findAll();
        List<MemberJoinReturnDto> returnDto = new ArrayList<>();

        for (Member member : allMember) {
            returnDto.add(new MemberJoinReturnDto(member));
        }

        return returnDto;
    }

    @Override
    public MemberJoinReturnDto join(MemberRegisterDto dto) {
        Member joinMember = new Member();
        joinMember.createMember(dto);
        MemberJoinReturnDto returnDto = new MemberJoinReturnDto(joinMember);
        memberRepository.save(joinMember);
        return returnDto;
    }
}
