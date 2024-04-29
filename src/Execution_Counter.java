import java.util.concurrent.Callable;

// CONTROLLER
class Execution_Counter {
    private static final Languages LANG = Languages.GER;
    static Translation translation = new Translation(LANG);

    public static void exec_function(FunctionInfo<?>[] functionArray) {


        double total_timed=0d;
        for (FunctionInfo<?> functionInfo : functionArray) {

            try {
                long start = System.currentTimeMillis();
                Object result;
                result = functionInfo.call();
                long end = System.currentTimeMillis();
                double timed = (end - start);
                if (result == null) {
                    result = "void";
                }
                if (result.toString().contains("Exception")) {
                        System.out.println(translation.getCross()+ translation.getExecutionTime() + String.format("%.6f", (timed / 1000)) +  translation.getSeconds()
                                + translation.getName()+ functionInfo.getFunctionName()
                                + translation.getResult() + result);

                } else {
                    System.out.println(translation.getCheck()+ translation.getExecutionTime() + String.format("%.6f", (timed / 1000)) +translation.getSeconds()
                            + translation.getName() + functionInfo.getFunctionName()
                            + translation.getResult()+ result);
                }
                total_timed += timed;
            } catch (Exception e) {
                String ss = "";
            }
        }
        System.out.println(translation.getStarTotalExecutionTime()+translation.getTotalExecutionTime() + String.format("%.6f", (total_timed / 1000)) + " "+ translation.getSeconds());

    }
}

// OBJECT<FUNCTIONINFO> TO OBTAIN FUNC INFO AND OUTPUT

class FunctionInfo<T> {
    private final String functionName;
    private final Callable<T> callableFunction;
    private final Runnable runnableFunction;

    /**
     * Creates an object that contains a Callable (returns output)<br>
     * It should be always an Array of <code>FunctionInfo<?></code> because of the <br>
     * logic implemented in <code>Execution_Counter<></code>.
     * @param functionName the name of the function, can be any name,<br>it is just to mark and show it in the debugger.
     * @param function must be the function as Lambda like the example down below.
     *
     *<br>
     * <br>EXAMPLE OF USE:
     * <br>
     * <code>FunctionInfo<?>[] functionArray = new FunctionInfo<?>[] { <br>
     * &emsp;&emsp;new FunctionInfo<>("example1", () -> Example.string("Hello World")),<br>
     * &emsp;&emsp;new FunctionInfo<>("example2", () -> Example.int(123456)),<br>
     * &emsp;&emsp;new FunctionInfo<>("example2", () -> Example::char)<br>
     * &emsp;&emsp;...<br>
     * };<br></code>
     */
    public FunctionInfo(String functionName, Callable<T> function) {

        this.functionName = functionName;
        this.callableFunction = function;
        this.runnableFunction = null;
    }

    /**
     * Creates an object that contains a Runnable (void function)<br>
     * It should be always an Array of <code>FunctionInfo<?></code> because of the <br>
     * logic implemented in <code>Execution_Counter<></code>.
     * @param functionName the name of the function, can be any name,<br>it is just to mark and show it in the debugger.
     * @param function must be the function as Lambda like the example down below.
     *
     *<br>
     * <br>EXAMPLE OF USE:
     * <br>
     * <code>FunctionInfo<?>[] functionArray = new FunctionInfo<?>[] { <br>
     * &emsp;&emsp;new FunctionInfo<>("example1", () -> Example.void1("Hello World")),<br>
     * &emsp;&emsp;new FunctionInfo<>("example2", () -> Example.void2()),<br>
     * &emsp;&emsp;new FunctionInfo<>("example3", () -> Example::void3),<br>
     * &emsp;&emsp;
     * &emsp;&emsp;...<br>
     * };<br></code>
     */
    public FunctionInfo(String functionName, Runnable function) {
        this.functionName = functionName;
        this.callableFunction = null;
        this.runnableFunction = function;
    }

    public String getFunctionName() {
        return functionName;
    }

    public T call() throws Exception {
            if (callableFunction != null) {
                try {
                    return callableFunction.call();
                } catch (Exception e){
                    StackTraceElement[] stackTrace = e.getStackTrace();
                    int lineNumber = 0;
                    String fileName = "";
                    if (stackTrace.length > 0) {
                        lineNumber = stackTrace[0].getLineNumber();
                        fileName = stackTrace[0].getFileName();
                    }
                    return (T) ("\u001b[31m"+(T) e.toString() + "\u001b[0m\u001b[37m" + "\n\t\t\t\t\t\t" + "\u001b[0m\u001b[31m" + Execution_Counter.translation.getErrorFinder() +": \u001b[0m \u001b[33m" + fileName + "::"+lineNumber + "\u001b[0m");
                }
            } else {
                assert runnableFunction != null;
                try {
                    runnableFunction.run();
                    return null;
                } catch (Exception e) {
                    StackTraceElement[] stackTrace = e.getStackTrace();
                    int lineNumber = 0;
                    String fileName = "";
                    if (stackTrace.length > 0) {
                        lineNumber = stackTrace[0].getLineNumber();
                        fileName = stackTrace[0].getFileName();
                    }
                    return (T) ("\u001b[31m"+(T) e.toString() + "\u001b[0m\u001b[37m" + "\n\t\t\t\t\t" + "\u001b[0m\u001b[31m" + Execution_Counter.translation.getErrorFinder() +": \u001b[0m \u001b[33m" + fileName + "::"+lineNumber + "\u001b[0m");
                }
            }


    }
}