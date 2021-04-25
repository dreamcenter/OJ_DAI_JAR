package top.dreamcenter.oj.util;

import top.dreamcenter.oj.property.PropertiesLoad;
import top.dreamcenter.oj.type.ResultType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessReadHandler extends Thread{
    private final Process process;
    private final String toRead;
    private ResultType resultType;

    public ProcessReadHandler(Process process, String toRead) {
        this.process = process;
        this.toRead = toRead;
    }
    //  thread data to main-thread
    @Override
    public void run() {
        try {
            processRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ResultType getResultType() {
        return resultType;
    }


    private void processRead() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));

        StringBuilder sb = new StringBuilder("\n");
        String temp;

        long outputLimit = PropertiesLoad.getInstance().getOutputPoor() * toRead.length();

        while((temp = bufferedReader.readLine())!=null){
            sb.append(temp).append("\n");
        }
        bufferedReader.close();
        if (sb.toString().equals(toRead)) {
            resultType = ResultType.AC;
        } else if (sb.toString().trim().equals(toRead.trim())){
            resultType = ResultType.PE;
        } else {
            resultType = ResultType.WA;
        }
        if(sb.length()>outputLimit){
            resultType = ResultType.OLE;
        }
    }
}
