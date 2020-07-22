package cn.ctrls.tmpoj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class CodeForcesController {
    @GetMapping("/CodeForces/contest/{Id}")
    public String ContestPage(HttpServletRequest request,
                              HttpServletResponse response,
                              @PathVariable(name = "Id",required = false) String Id){
        if (Id==null||!Id.matches("[0-9]*?"))
            return "error";
        System.out.println(Id);
        request.setAttribute("ok",1);
        response.addCookie(new Cookie("OK","1"));
        return "index";
    }
}
