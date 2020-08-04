package cn.ctrls.tmpoj.controller;

import cn.ctrls.tmpoj.config.CookieConfig;
import cn.ctrls.tmpoj.mapper.ConfigMapper;
import cn.ctrls.tmpoj.model.Config;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class ConfigController {
    @Resource(name = "cookieConfig")
    CookieConfig cookieConfig;

    @GetMapping("/config/update/")
    public String updateCookie(@RequestParam(name = "NowCoderCookie", required = false) String nowCoderCookie,
                               @RequestParam(name = "CodeForcesCookie", required = false) String codeForcesCookie){
        Config config = cookieConfig.getConfig();
        if (config==null){
            config = new Config();
            config.setId(1);
            config.setNowCoderCookie(nowCoderCookie);
            config.setCodeForcesCookie(codeForcesCookie);
            cookieConfig.insert(config);
            return "index";
        }
        if (nowCoderCookie==null) nowCoderCookie=config.getNowCoderCookie();
        if (codeForcesCookie==null) codeForcesCookie=config.getCodeForcesCookie();
        config.setNowCoderCookie(nowCoderCookie);
        config.setCodeForcesCookie(codeForcesCookie);
        cookieConfig.update(config);
        return "index";
    }
    @GetMapping("/config/show")
    public String showCookie(){
        Config config = cookieConfig.getConfig();
        if (config==null) {
            System.out.println("IT is NULL");
            return "index";
        }
        return "index";
    }
}
