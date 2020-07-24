package cn.ctrls.tmpoj.Spider;

import cn.ctrls.tmpoj.dto.ContestInfo;
import cn.ctrls.tmpoj.dto.ProblemContent;
import cn.ctrls.tmpoj.utils.fileUtils.UploadFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.UUID;

@Component(value = "cfSpider")
public class CodeForcesSpider {
    @Value("${CodeForces.remotePath}")
    private String remotePath;

    @Resource(name = "cfAnalyzer")
    CodeForcesAnalyzer cfAnalyzer;

    @Resource(name = "uploadUtil")
    UploadFile upload;

    public ProblemContent getProblemContentById(String id){
        ProblemContent problemContent = cfAnalyzer.getProblemContent(id);
        //ops出错了！
        if (problemContent==null)return null;
        //题目入库！
        problemContent.setRemoteId(upload.uploadString(problemContent.getContent(),remotePath+UUID.randomUUID()+".html"));
        return problemContent;
    }

    public ContestInfo getContestInfoById(String id){
        ContestInfo contestInfo = cfAnalyzer.getContestInfo(id);
        //如果出错了的话（测试不存在或者网络问题）
        if (contestInfo==null) return null;
        //加入到库存中
        contestInfo.setRemoteId(upload.uploadString(contestInfo.getContent(),remotePath + UUID.randomUUID() + ".html"));
        return contestInfo;
    }

    public ArrayList<ProblemContent> getProblemsByContestId(String id){
        return getContestInfoById(id).getProblems();
    }


}
