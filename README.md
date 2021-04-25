# OJ_DAI_JAR_v1.0.0

---

<b style='color:red'>only for c++ language judgement in this version</b>

---
### QUICKUSE
> 1| PropertiesLoad.load(properties);
> 
> 2| OjJudgement ojJudgement = new OjJudgement(1,1,content,uid);
>
> 3| ResultType[] rt = ojJudgement.getResult();
> 
> 4| System.out.println(PrintFormat.resultTypeArrayFormat(rt));

1. Load properties to the oj environment [must]<br/>
   if not (<i style='color:red'>PropertiesNotLoadException</i>) will throw
2. the core starter of the oj system<br>
3. getResult() method will return ResultType[]    
   which represents to each test data judge result
4. print the result in a formatted string
---
### HOW TO START
1. make a directory build for TaskBase<br/>
   (where will store all exercises)
2. make a directory build for UserBase<br/>
   (where will store user codes)
3. you need to build your directory in this way :<br/>
   1. TaskBase / task / exercise / input.txt & output.txt<br/>
   2. UserBase / task / exercise
    > task = task1 / task2/task3/.../task10/task11...
    > 
    > exercise = 1 / 2 / 3 / 4 / ...
4. the rule to write input.txt and output.txt
    1. use one character which will not exist in test data<br/>
       this character is need to be used to split each test data
    2. all new line will be detected as one part of test data,<br/>
       so you need to think if you need this new line
    3. \n is auto added to each test data
```text
e.g.
if you want to design this :
        testdata1   testdata2   testdata3
input :     1           2           3
output: *           *           *
                    **          **
                                ***
you can write your file like this:
--------------
input.txt
*
1
*
2
*
3
---------------
output.txt
&
*
&
*
**
&
*
**
***
-------------
in input.txt,
'*' is not a character in input test data,
so you can use here.
in output.txt,
'*' has exist in output test data,
so you can not use here
```
5. properties needed
```text
taskBase    [must]      the path of taskBase
userBase    [must]      the path of userBase
compiler    [must]      the path of g++.exe
answerPoor  [default=5] max count of exercises in one task
outputPoor  [default=10^6]
                        related to 'OLE' error,
                        if user output > outputPoor * test output
                        'OLE' error will be throwed
```

6. loadProperties
> PropertiesLoad.load(properties);

7. new OjJudgement
> OjJudgement(int taskId, int exerciseId, String content, String uid)
> 
> taskId = 1 / 2 / 3 / 4 / ...
> 
> exerciseId = 1 / 2 / 3 / ...
> 
> content = the full code
> 
> uid = userId

8. getResult
> ResultType[] rt = ojJudgement.getResult();
> 
> that's all, result has been stored to rt

9. what is ResultType?
```java
package top.dreamcenter.oj.type;

public enum ResultType {
    /**
     * @return  +   AC  ACCEPTED
     *          +   CE  COMPILATION_ERROR
     *          +   WA  WRONG_ANSWER
     *          +   TLE TIME_LIMIT_EXCEEDED
     *          +   RE  RUNTIME_ERROR
     *          -   MLE MEMORY_LIMIT_EXCEEDED   -WILL NOT REALIZE
     *          +   PE  PRESENTATION_ERROR
     *          +   OLE OUTPUT_LIMIT_EXCEEDED
     */
    AC, CE, WA, TLE,
    RE, MLE, PE, OLE;
}
```
> tip :  TLE was set to 1s limit in this version;
>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
> OLE has not been realized
> (because I cannot realize it)


---
### demo
Actually in this project, I have use one test demo!
You can regard the OJBase directory as a reference
to the building of directory.
You can regard the Test.java as a reference to use
this oj system.

you can use the method below to quick print the result
> PrintFormat.resultTypeArrayFormat(ResultType[] rt)



---
### AUTHOR
<b style="border-bottom:2px solid coral;">DAI</b>
<BR><BR><BR><BR><BR><BR>