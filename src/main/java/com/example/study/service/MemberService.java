package com.example.study.service;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.study.domain.Member;
import com.example.study.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true) // 읽기 전용으로 하게되면 퍼포먼스상 이점이 많다. db한테 이건 읽기전용이라고 알려 줄 수 있다.
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     회원 가입
     */
    @Transactional // join 은 insert 이기 때문에 transaction readOnly false 로 둔다.
    public Long join(Member member) {
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId(); // 항상 값이 있다고 보장이 된다.
    }

    private void validateDuplicateMember(Member member) {
        //Exception
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    /**
     * 회원 전체 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /**
     * 회원 단건 조회
     */
    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }
    
}