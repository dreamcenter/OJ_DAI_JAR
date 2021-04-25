package top.dreamcenter.oj.util;

import java.io.*;

public class WriteContent {
    private String path;
    private String fileName;
    private String content;

    public WriteContent(String path, String fileName, String content) {
        this.path = path;
        this.fileName = fileName;
        this.content = content;
    }

    public void write() throws IOException {
        File file = new File(path + "\\" + fileName);
        if (file.exists()||file.createNewFile()) {
            BufferedWriter bufferedWriter = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(file)));
            bufferedWriter.write(content);
            bufferedWriter.flush();
            bufferedWriter.close();
            System.out.println("OJ-DAI-TIP : " + fileName + " create successful!");
        } else {
            System.err.println("OJ-DAI-ERR : on create " + fileName + " err!");
        }
    }
}
