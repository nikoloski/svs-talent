package com.seavus.service.entityservice;

import com.seavus.entity.member.Member;
import com.seavus.entity.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void registerMember(Member member) {
        memberRepository.save(member);
    }

    public List<Member> listMembers() {
        return (List<Member>) memberRepository.findAll();
    }
}
