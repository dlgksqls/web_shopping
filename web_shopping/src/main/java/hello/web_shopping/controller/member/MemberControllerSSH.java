package hello.web_shopping.controller.member;

import hello.web_shopping.dto.member.MemberJoinReturnDto;
import hello.web_shopping.dto.member.MemberRegisterDto;
import hello.web_shopping.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("memberssh")
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

    @GetMapping("/{memberId}")
    public String item(@PathVariable String memberId, Model model) {
        MemberJoinReturnDto member = memberService.findByLoginId(memberId);

        model.addAttribute("member", member);

        return "member/memberInfo";
    }
}
