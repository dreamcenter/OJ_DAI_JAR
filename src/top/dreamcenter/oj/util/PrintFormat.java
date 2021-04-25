package top.dreamcenter.oj.util;

import top.dreamcenter.oj.type.ResultType;

public class PrintFormat {
    public static String resultTypeArrayFormat(ResultType[] rt){
        StringBuffer format = new StringBuffer("[");
        for (int i = 0; i < rt.length-1; i++) {
            format.append(rt[i] + ",");
        }
        format.append(rt[rt.length-1] + "]");
        return format.toString();
    }
}
