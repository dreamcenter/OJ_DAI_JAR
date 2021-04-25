package top.dreamcenter.oj.property;

import java.util.Properties;

public class PropertiesLoad {
    private final Properties properties;
    private static PropertiesLoad instance;
    private PropertiesLoad(Properties properties) {
        this.properties = properties;
    }

    /**
     * a recommended method to know if manager has defined successfully
     */
    public static void selfCheck() {
        if (instance == null) {
            throw new PropertiesNotLoadException();
        }
    }

    /**
     * if you want to use this method, you need use getInstance(properties) first
     * @return the instance of the class
     */
    public static PropertiesLoad getInstance() {
        if (instance == null) {
            throw new PropertiesNotLoadException();
        }
        return instance;
    }

    /**
     * basic constructor to get the instance of this class
     * @param properties
     * @return
     */
    public static PropertiesLoad load(Properties properties) {
        if (instance == null) {
            instance = new PropertiesLoad(properties);
        }
        return instance;
    }

    /**
     * get the taskBase from properties
     * @return
     * @throws Exception
     */
    public String getTaskBase() throws Exception {
        String taskBase = properties.getProperty("taskBase");
        if (taskBase == null) {
            throw new Exception("taskBase not defined in properties");
        }
        return taskBase;
    }

    /**
     * get the userBase from properties
     * @return
     * @throws Exception
     */
    public String getUserBase() throws Exception {
        String userBase = properties.getProperty("userBase");
        if (userBase == null) {
           throw new Exception("userBase not defined in properties");
        }
        return userBase;
    }

    /**
     * get the compiler from properties
     * @return
     * @throws Exception
     */
    public String getCompiler() throws Exception {
        String compiler = properties.getProperty("compiler");
        if (compiler == null) {
            throw new Exception("compiler not defined in properties");
        }
        return compiler;
    }

    /**
     * get the answerPoor of properties
     * @return  default 5
     */
    public int getAnswerPoor() {
        int poor = 5;
        String temp = properties.getProperty("answerPoor");
        if (temp != null) poor = Integer.parseInt(temp);
        return poor;
    }

    /**
     * get the outputPoor of properties
     * @return  default 10^6
     */
    public long getOutputPoor() {
        long poor = 1000000;
        String temp = properties.getProperty("outputPoor");
        if (temp != null) poor = Long.parseLong(temp);
        return poor;
    }
}
