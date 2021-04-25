package top.dreamcenter.oj.sub;

import top.dreamcenter.oj.property.PropertiesLoad;
import top.dreamcenter.oj.type.ResultType;
import top.dreamcenter.oj.util.ProcessReadHandler;

import java.io.*;
import java.util.List;

public class Execute {
    private final List<String> input;
    private final List<String> output;
    private final String filePath;
    private Process process;

    public Execute(List<String> input, List<String> output, String filePath) {
        this.input = input;
        this.output = output;
        this.filePath = filePath;
    }

    private void processWrite(String toWrite) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(process.getOutputStream()));

        bufferedWriter.write(toWrite);

        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public ResultType[] getResult() throws Exception {
        int poorSize = PropertiesLoad.getInstance().getAnswerPoor();
        if (input.size()!=output.size()) {
            throw new RuntimeException("OJ-DAI-ERR : input lines != output lines!");
        }
        if (input.size()>poorSize) {
            throw new RuntimeException("OJ-DAI-ERR : input lines > poorSize!");
        }

        ProcessReadHandler[] prh = new ProcessReadHandler[poorSize];
        ResultType[] rt = new ResultType[input.size()];

        for (int i = 0; i < input.size(); i++) {
//            String procgov = PropertiesLoad.getInstance().getCompiler().substring(0,15)+"procgov";
//            process = Runtime.getRuntime().exec(procgov + " -maxmem 1K --quiet" + filePath);
            process = Runtime.getRuntime().exec(filePath);
            processWrite(input.get(i));

            prh[i] = new ProcessReadHandler(process, output.get(i));
            prh[i].start();

            Thread.sleep(1000);
            if(prh[i].isAlive()) rt[i] = ResultType.TLE;
            else rt[i] = prh[i].getResultType();
            process.destroy();  //  OLE only happened when process close
        }

        Thread.sleep(100);
        for (int i = 0; i < input.size(); i++) {
            rt[i] = prh[i].getResultType()==ResultType.OLE ? ResultType.OLE : rt[i];
        }

        //********
        process.destroy();
        return rt;
    }
}
