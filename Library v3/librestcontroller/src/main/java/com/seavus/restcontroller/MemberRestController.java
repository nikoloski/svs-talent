package com.seavus.restcontroller;

import com.seavus.entity.member.Member;
import com.seavus.service.entityservice.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberRestController {

    private MemberService memberService;

    public MemberRestController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public List<Member> listMembers() {
        return memberService.listMembers();
    }

    @PostMapping
    public void createMember(@RequestBody Member member) {
        memberService.registerMember(member);
    }
}
