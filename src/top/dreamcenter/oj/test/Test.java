package top.dreamcenter.oj.test;

import top.dreamcenter.oj.core.OjJudgement;
import top.dreamcenter.oj.property.PropertiesLoad;
import top.dreamcenter.oj.type.ResultType;
import top.dreamcenter.oj.util.PrintFormat;

import java.util.Properties;

public class Test {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(Test.class.getClassLoader().getResourceAsStream("test.properties"));

        String content = "#include<iostream>\n" +
                "using namespace std;\n\n" +
                "int main(){\n" +
                "    int temp;\n" +
                "    cin>>temp;\n" +
                "    for(int i = 1;i<=temp;i++){\n" +
                "        for(int j=1;j<=i;j++) {\n" +
                "            cout<<\"*\";\n" +
                "        }\n" +
                "        cout<<endl;\n" +
                "    }\n" +
                "    return 0;\n" +
                "}\n";
        String uid = "111904130127";

        PropertiesLoad.load(properties);
        OjJudgement ojJudgement = new OjJudgement(1,1,content,uid);

        ResultType[] rt = ojJudgement.getResult();
        System.out.println(PrintFormat.resultTypeArrayFormat(rt));
    }
}
