package cn.ctrls.tmpoj.config;

import cn.ctrls.tmpoj.mapper.ConfigMapper;
import cn.ctrls.tmpoj.model.Config;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("cookieConfig")
public class CookieConfig {
    @Resource(name = "configMapper")
    ConfigMapper configMapper;
    private Config config;

    public Config getConfig(){
        if (config==null){
            config = configMapper.getConfig();
        }
        if (config==null)return null;
        return config;
    }

    public String getNowCoderCookie(){
        if (getConfig()==null)return null;
        return config.getNowCoderCookie();
    }

    public String getCodeForcesCookie(){
        if (getConfig()==null)return null;
        return config.getNowCoderCookie();
    }

    public void insert(Config config){
        configMapper.insertConfig(config);
        this.config = config;
    }

    public void update(Config config){
        configMapper.updateConfig(config);
        this.config = config;
    }
}
