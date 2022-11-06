package com.security.security1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //View를 리턴하겠다는 뜻
public class IndexController {

    @GetMapping({"","/"})
    public String index(){
        return "index";
    }
}
