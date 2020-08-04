package cn.ctrls.tmpoj.mapper;

import cn.ctrls.tmpoj.mapper.inter.OJMapper;
import cn.ctrls.tmpoj.model.CodeForcesContest;
import cn.ctrls.tmpoj.model.CodeForcesProblem;
import cn.ctrls.tmpoj.model.NowCoderContest;
import cn.ctrls.tmpoj.model.NowCoderProblem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository(value = "nkMapper")
public interface NowCoderMapper extends OJMapper {
    @Insert({"INSERT INTO nk_contest (id,contest_title,problems_count,remote_id,problems) VALUES (#{id},#{contestTitle},#{problemsCount},#{remoteId},#{problems})"})
    public void insertContest(NowCoderContest codeForcesContest);
    @Insert({"INSERT INTO nk_problems (id, title, remote_id) VALUES (#{id},#{title},#{remoteId})"})
    public void insertProblem(NowCoderProblem codeForcesProblem);
    @Select("SELECT remote_id from nk_contest where id = #{id}")
    public String getContestRemoteId(String id);
    @Select("SELECT remote_id from nk_problems where id = #{id}")
    public String getProblemRemoteId(String id);
    @Select("SELECT * FROM nk_contest WHERE id = #{contestId}")
    public NowCoderContest getContest(String contestId);
}
