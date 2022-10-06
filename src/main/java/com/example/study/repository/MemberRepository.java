package com.example.study.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.example.study.domain.Member;

import lombok.RequiredArgsConstructor;

@Repository // spring bean 으로 등록해줌
@RequiredArgsConstructor
public class MemberRepository {

    // entity manager 를 주입함
    private final EntityManager em;

    public void save(Member member) {
        em.persist(member); // 영속성 context 에 member 엔티티를 넣고, transaction commit 시점에 insert 된다.
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id); // 단건 조회
    }

    public List<Member> findAll() {
        // JPQL 문법의 from 대상이 테이블이 아닌 엔티티 객체가 된다. 기본편 강의를 보면 더 잘 알 수 있다고..ㅠ
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }

}