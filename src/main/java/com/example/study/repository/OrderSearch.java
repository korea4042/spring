package com.example.study.repository;

import com.example.study.domain.OrderStatus;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderSearch {

    private String memberName;
    private OrderStatus orderStatus;
    
}
