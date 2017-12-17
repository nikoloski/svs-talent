package com.seavus.entityservice;

import com.seavus.entity.member.Member;
import com.seavus.entity.member.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void registerMember(Member member) {
        memberRepository.save(member);
        System.out.println("The member was registered.");
    }

    public void listMembers() {
        Iterable<Member> members = memberRepository.findAll();
        for (Member member : members) {
            System.out.println(member.toString());
        }
    }
}
