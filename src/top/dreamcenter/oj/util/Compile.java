package top.dreamcenter.oj.util;

import top.dreamcenter.oj.type.ResultType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Compile {
    public static ResultType compile(String compiler, String path,String uid) throws IOException {
        String target = path + "\\" + uid;
        String cmd = compiler + " -o " + target + ".exe " + target + ".cpp";
        Process process = Runtime.getRuntime().exec(cmd);
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(process.getErrorStream()));
        StringBuffer tempBuffer = new StringBuffer();
        String res;
        while((res=bufferedReader.readLine())!=null){
            tempBuffer.append(res);
        }
        res = tempBuffer.toString();
        System.out.println(res);

        bufferedReader.close();

        if(res.contains("error")) {
            return ResultType.CE;
        }else if(res.contains("warn")) {
            return ResultType.RE;
        } else {
            System.out.println("OJ-DAI-TIP : " + uid + ".cpp compile success!");
            return null;
        }
    }
}
