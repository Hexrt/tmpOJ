package cn.ctrls.tmpoj.mapper;

import cn.ctrls.tmpoj.model.Config;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository(value = "configMapper")
public interface ConfigMapper {
    //注意了
    //这里的ID默认全为1，防止多个cookie存在，拓展的话需要这里修改
    @Insert("INSERT INTO config (id, now_coder_cookie, code_forces_cookie) VALUES (1, #{nowCoderCookie}, #{codeForcesCookie})")
    public void insertConfig(Config config);
    @Update("UPDATE config SET id=1, now_coder_cookie=#{nowCoderCookie}, code_forces_cookie=#{codeForcesCookie} WHERE id=1")
    public void updateConfig(Config config);
    @Select("SELECT * FROM config WHERE id = 1")
    public Config getConfig();
    @Select("SELECT now_coder_cookie FROM config WHERE id=1")
    public String getNowCoderCookie();
    @Select("SELECT code_forces_cookie FROM config WHERE id=1")
    public String getCodeForcesCookie();
}
