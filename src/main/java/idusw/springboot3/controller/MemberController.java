package idusw.springboot3.controller;

import idusw.springboot3.domain.Member;
import idusw.springboot3.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/members")
public class MemberController {
    // Constructor DI(Dependency Injection)
    MemberService memberService;
    public MemberController(MemberService memberService) { // Spring Framework이 주입(하도록 요청함)
        this.memberService = memberService;
    }
    HttpSession session = null;
    @GetMapping("/login-form")
    public String getLoginform(Model model) {
        model.addAttribute("member", Member.builder().build()); // email / pw 전달을 위한 객체
        return "/members/login"; // view : template engine - thymeleaf .html
    }
    @PostMapping("/login")
    public String loginMember(@ModelAttribute("member") Member member, HttpServletRequest request) { // 로그인 처리 -> service -> repository -> service -> controller
        Member result = null;
        if((result = memberService.login(member)) != null ) { // 정상적으로 레코드의 변화가 발생하는 경우 영향받는 레코드 수를 반환
            session = request.getSession();
            session.setAttribute("mb", result);
            return "redirect:/";
        }
        else
            return "/main/error";
    }
    @GetMapping("/logout")
    public String logoutMember() {
        session.invalidate();
        return "redirect:/";
    }
    @GetMapping(value = {"", "/"})
    public String listMember(Model model) {
        List<Member> result = null;
        if((result = memberService.readList()) != null) {
            model.addAttribute("list", result);
            return "/members/list";
        }
        else
            return "/errors/404";
    }
    @GetMapping("/register-form")
    public String getRegisterForm(Model model) { // form 요청 -> view (template engine)
        model.addAttribute("member", Member.builder().build());
        return "/members/register";
    }
    @PostMapping("/")
    public String createMember(@ModelAttribute("member") Member member, Model model) { // 등록 처리 -> service -> repository -> service -> controller
        if(memberService.create(member) > 0 ) // 정상적으로 레코드의 변화가 발생하는 경우 영향받는 레코드 수를 반환
            return "redirect:/";
        else
            return "/errors/404";
    }
    @GetMapping("/{seq}")
    public String getMember(@PathVariable("seq") Long seq, Model model) {
        Member result = new Member(); // 반환
        Member m = new Member(); // 매개변수로 전달
        m.setSeq(seq);
        result = memberService.read(m);
        // MemberService가 MemberRepository에게 전달
        // MemberRepository는 JpaRepository 인터페이스의 구현체를 활용할 수 있음
        model.addAttribute("member", result);
        return "/members/detail";
    }

    @PutMapping("/{seq}")
    public String updateMember(@ModelAttribute("member") Member member, Model model) { // 수정 처리 -> service -> repository -> service -> controller
        if(memberService.update(member) > 0 ) {
            session.setAttribute("mb", member);
            return "redirect:/";
        }
        else
            return "/errors/404";
    }
    @DeleteMapping("/{seq}")
    public String deleteMember(@ModelAttribute("member") Member member) { // 삭제 처리 -> service -> repository -> service -> controller
        if(memberService.delete(member) > 0) {
            session.invalidate();
            return "redirect:/";
        }
        else
            return "/errors/404";
    }
    @GetMapping("/forgot") // 조회 read
    public String getForgotform() { // 분실 비밀번호 처리 요청 -> view
        return "/members/forgot-password"; // view : template engine - thymeleaf .html
    }
    @PostMapping("/forgot") // create vs  update -> @PutMapping, delete -> @DeleteMapping
    public String forgotMemberPassword() { // 비밀번호(갱신) -> service -> repository -> service -> controller
        return "redirect:/"; // 루트로 이동
    }
    @GetMapping("/list")
    public String goList(Model model) {

        List<Member> result = null;
        if((result = memberService.readList()) != null) {
            model.addAttribute("list", result);
            return "/members/list2";
        }
        else
            return "/errors/404";
    }
}