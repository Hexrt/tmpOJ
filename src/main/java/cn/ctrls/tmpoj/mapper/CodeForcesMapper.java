package cn.ctrls.tmpoj.mapper;

import cn.ctrls.tmpoj.model.CodeForcesContest;
import cn.ctrls.tmpoj.model.CodeForcesProblem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository(value = "cfMapper")
public interface CodeForcesMapper {
    @Insert({"INSERT INTO cf_contest (id,contest_title,problems_count,remote_id,problems) VALUES (#{id},#{contestTitle},#{problemsCount},#{remoteId},#{problems})"})
    public void insertContest(CodeForcesContest codeForcesContest);
    @Insert({"INSERT INTO cf_problems (id, title, remote_id) VALUES (#{id},#{title},#{remoteId})"})
    public void insertProblem(CodeForcesProblem codeForcesProblem);
    @Select("SELECT remote_id from cf_contest where id = #{id}")
    public String getContestRemoteId(String id);
    @Select("SELECT remote_id from cf_problems where id = #{id}")
    public String getProblemRemoteId(String id);
    @Select("SELECT * FROM cf_contest WHERE id = #{contestId}")
    public CodeForcesContest getContest(String contestId);
}
