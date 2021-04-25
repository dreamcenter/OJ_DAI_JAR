package top.dreamcenter.oj.core;

import top.dreamcenter.oj.property.PropertiesLoad;
import top.dreamcenter.oj.sub.Task;
import top.dreamcenter.oj.type.ResultType;
import top.dreamcenter.oj.util.Compile;
import top.dreamcenter.oj.util.WriteContent;


public class OjJudgement {
    private final int taskId;
    private final int exerciseId;
    private final String content;
    private final String uid;

    public OjJudgement(int taskId, int exerciseId, String content, String uid) {
        this.taskId = taskId;
        this.exerciseId = exerciseId;
        this.content = content;
        this.uid = uid;
    }

    private ResultType writeCompile() throws Exception {
        String path = PropertiesLoad.getInstance().getUserBase() + "\\task" + taskId
                + "\\" + exerciseId;
        String fileName = uid + ".cpp";
        WriteContent writeContent = new WriteContent(path,fileName,content);
        writeContent.write();

        return Compile.compile(PropertiesLoad.getInstance().getCompiler(), path , uid);
    }

    /**
     *
     * @return  all test data result
     *          [CE][RE]     ONLY ONE RESULT IN ANSWER
     *          [,,,]   OTHERS WILL GET ALL POSSIBILITIES
     * @throws Exception
     */
    public ResultType[] getResult () throws Exception {
        ResultType temp = writeCompile();
        if(temp!=null){
            ResultType[] rt = new ResultType[1];
            rt[0] = temp;
            return rt;
        }
        return new Task(taskId,exerciseId,uid).start();
    }
}
