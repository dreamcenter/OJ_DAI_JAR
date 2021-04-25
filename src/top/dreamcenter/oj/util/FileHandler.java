package top.dreamcenter.oj.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileHandler {
    public static String getStringOfFile(String taskPath, int exerciseId, String type) throws IOException {
        String readFile = taskPath + "\\" + exerciseId + "\\"+ type + ".txt";
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream(readFile)));
        StringBuffer sb = new StringBuffer();
        String temp;
        while((temp = bufferedReader.readLine())!=null) {
            sb.append(temp + "\n");
        }
        bufferedReader.close();
        return sb.toString();
    }
}
