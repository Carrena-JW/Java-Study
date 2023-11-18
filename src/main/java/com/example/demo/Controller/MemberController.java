package com.example.demo.Controller;

import com.example.demo.Domain.Member;
import com.example.demo.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;
    @Autowired
    public MemberController(MemberService _memberService) {
        this.memberService = _memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm mf){
        Member member = new Member();
        member.setName(mf.getName());
        System.out.println(mf.getName());
        memberService.Join(member);
        return "redirect:/";

    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> allMembers =   memberService.FindAllMembers();
        model.addAttribute("members", allMembers);

        return "members/memberList";
    }
}
