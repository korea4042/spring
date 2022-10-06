package com.example.study;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.study.domain.Member;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        Hello hello = new Hello();
		hello.setHello("15123");
		String data = hello.getHello();
        model.addAttribute("data", data);
        Member member = new Member();
        member.setName("홍길동");
        System.out.println(member);
        return "hello";
    }
}