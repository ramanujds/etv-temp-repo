package com.jpm.app.api;

import com.jpm.app.service.UserService;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Scope("prototype")
public class GreetApi {

    @Autowired
    Environment env;

    @Autowired
    private UserService service;

    @PostConstruct
    public void init(){
        System.out.println("User Api Bean Initialized");
    }

    @GetMapping("/")
    public String greet(HttpServletRequest request){
        request.setAttribute("m1",service.getMessage());
        return "index.jsp";
    }

    @ResponseBody
    @GetMapping("/greet")
    public String greetMessage(){
        return service.getMessage()+
                " | from "+env.getProperty("repo.username");
    }

}
