package com.example.study.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Delivery {
    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;
    
    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;
    
    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING) // ORDINARY 는 순서에 의해 숫자로 세팅되는데, 중간에 값이 세팅되면 문제가 발생할 수 있음
    private DeliveryStatus status; //READY, COMP
}
