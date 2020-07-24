package cn.ctrls.tmpoj.utils.fileUtils;

import org.junit.jupiter.api.Test;

class UploadFileTest {

    @Test
    void uploadFile() {
        UploadFile uploadFile = new UploadFile();
        uploadFile.UploadFile("C:\\Users\\Yoosec\\Desktop\\problem.html","index.html");
    }
}