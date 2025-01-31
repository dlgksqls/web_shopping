package hello.web_shopping.controller.member;

import hello.web_shopping.dto.member.MemberJoinReturnDto;
import hello.web_shopping.dto.member.MemberLoginDto;
import hello.web_shopping.dto.member.MemberRegisterDto;
import hello.web_shopping.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/memberssh")
@RequiredArgsConstructor
public class MemberControllerSSH {

    private final MemberService memberService;

    @GetMapping("/add")
    public String memberRegisterForm(Model model){
        model.addAttribute("member", new MemberRegisterDto());
        return "member/add";
    }

    @PostMapping("/add")
    public String memberRegisterSuccessForm(@ModelAttribute MemberRegisterDto member, RedirectAttributes redirectAttributes){
        memberService.join(member);

        redirectAttributes.addAttribute("memberId", member.getLoginId());

        return "redirect:/memberssh/{memberId}";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("member", new MemberLoginDto());
        return "member/login";
    }

    @PostMapping("/login")
    public String loginForm(@ModelAttribute MemberLoginDto member, RedirectAttributes redirectAttributes) {
        if (!memberService.login(member)) {
            redirectAttributes.addFlashAttribute("errorMessage", "로그인에 실패했습니다. 아이디와 비밀번호를 확인하세요.");
            return "redirect:/memberssh/login";
        }

        String loginId = member.getLoginId();
        redirectAttributes.addAttribute("loginId", loginId); // 쿼리 파라미터로 전달
        return "redirect:/itemssh";
    }

    @GetMapping("/{memberId}")
    public String findMember(@PathVariable String memberId, Model model) {
        MemberJoinReturnDto member = memberService.findByLoginId(memberId);

        model.addAttribute("member", member);

        return "memberJoinSuccess";
    }
}
