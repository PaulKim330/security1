package com.security.security1.controller;

import com.security.security1.model.Member;
import com.security.security1.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //View를 리턴하겠다는 뜻
public class IndexController {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping({"","/"})
    public String index(){
        return "index";
    }

    @GetMapping({"/user"})
    public @ResponseBody String user(){
        return "user";
    }

    @GetMapping({"/admin"})
    public @ResponseBody String admin(){
        return "admin";
    }
    @GetMapping({"/manager"})
    public @ResponseBody String manager(){
        return "manager";
    }
    @GetMapping({"/login"})
    public String login(){
        return "login";
    }
    @GetMapping({"/loginForm"})
    public String loginForm(){
        return "loginForm";
    }
    @GetMapping({"/joinForm"})
    public String joinForm(){
        return "joinForm";
    }
    @PostMapping({"/join"})
    public String join(Member member){
        System.out.println(member);
        member.setRole("ROLE_USER");
        String rawPassword = member.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        member.setPassword(encPassword);
        memberRepository.save(member);
        return "redirect:/loginForm";
    }
}
