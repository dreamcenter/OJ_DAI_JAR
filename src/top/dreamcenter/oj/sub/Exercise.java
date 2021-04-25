package top.dreamcenter.oj.sub;

import top.dreamcenter.oj.property.PropertiesLoad;
import top.dreamcenter.oj.type.ResultType;
import top.dreamcenter.oj.util.FileHandler;
import top.dreamcenter.oj.util.StringHandler;

import java.io.*;
import java.util.List;

public class Exercise {
    private final int taskId;
    private final int exerciseId;
    private String uid;
    private String taskPath;

    public Exercise(int taskId, int exerciseId, String uid) throws Exception {
        this.taskId = taskId;
        this.exerciseId = exerciseId;
        this.uid = uid;
        taskPath = PropertiesLoad.getInstance().getTaskBase()
                + "\\task" + taskId;
    }

    private List<String> getInput() throws IOException {
        return StringHandler.cutString(
                FileHandler.getStringOfFile(taskPath, exerciseId, "input"));
    }

    private List<String> getOutput() throws IOException {
        return StringHandler.cutString(
                FileHandler.getStringOfFile(taskPath, exerciseId, "output"));
    }

    public ResultType[] start() throws Exception {
        String filePath = PropertiesLoad.getInstance().getUserBase()
                + "\\task" + taskId + "\\" + exerciseId + "\\" + uid + ".exe";
        System.out.println(filePath);
        return new Execute(getInput(),getOutput(),filePath).getResult();
    }
}
