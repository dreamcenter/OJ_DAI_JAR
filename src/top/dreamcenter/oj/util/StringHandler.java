package top.dreamcenter.oj.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringHandler {
    /**
     *
     * @param str The String to be cut by the first character into list<String>
     * @return  List<String>
     */
    public static List<String> cutString(String str){
        List<String> temp =new ArrayList<String>(
                Arrays.asList(str.split(String.valueOf(str.charAt(0)))));
        temp.remove(0);
        return temp;
    }
}
