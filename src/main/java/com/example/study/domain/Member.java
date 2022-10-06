package com.example.study.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter // 권장하지 않는다.
@Entity
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    // 안넣으면 그냥 id가 된다
    private Long id;

    private String name;

    @Embedded // 내장됐다. 
    // 내장타입을 쓸때는 Embedded, Embedable 둘 중 하나만 있어도 됌
    private Address address;

    @OneToMany(mappedBy = "member") // 하나의 회원이 다수의 주문을 할 수 있기에 one to many
    private List<Order> orders;

    public Member() {
        orders = new ArrayList<>();
    }
}