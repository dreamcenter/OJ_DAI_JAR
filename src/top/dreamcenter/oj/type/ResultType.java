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
