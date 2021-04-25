package top.dreamcenter.oj.sub;

import top.dreamcenter.oj.property.PropertiesLoad;
import top.dreamcenter.oj.type.ResultType;

public class Task {
    private int taskId;
    private int exerciseId;
    private String uid;

    public Task(int taskId, int exerciseId, String uid) {
        PropertiesLoad.selfCheck();
        this.taskId = taskId;
        this.exerciseId = exerciseId;
        this.uid = uid;
    }

    public ResultType[] start() throws Exception {
        String taskBase = PropertiesLoad.getInstance().getTaskBase();
        return new Exercise(taskId,exerciseId,uid).start();
    }
}
