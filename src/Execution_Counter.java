import java.util.concurrent.Callable;

// CONTROLLER
class Execution_Counter {
    private static final Languages LANG = Languages.ENG;
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
     * &emsp;&emsp;new FunctionInfo<>("yourFunction1", () -> {<br>
     * &emsp;&emsp;&emsp;&emsp;try{<br>
     * &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;return Main.yourFunction1();<br>
     * &emsp;&emsp;&emsp;&emsp;} catch (Exception e) {<br>
     * &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;return Error_Handler.pop_error(e);<br>
     * &emsp;&emsp;&emsp;&emsp;}<br>
     * &emsp;&emsp;&emsp;&emsp;}),<br>
     * &emsp;&emsp;new FunctionInfo<>("yourFunction2", () -> {<br>
     * &emsp;&emsp;&emsp;&emsp;try {<br>
     * &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Main.yourFunction2();<br>
     * &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;return null;<br>
     * &emsp;&emsp;&emsp;&emsp;} catch (Exception e) {<br>
     * &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;return Error_Handler.pop_error(e);<br>
     * &emsp;&emsp;&emsp;&emsp;}<br>
     * &emsp;&emsp;&emsp;&emsp;}),<br>
     * &emsp;&emsp;new FunctionInfo<>("yourFunction3", () ->  {<br>
     * &emsp;&emsp;&emsp;&emsp;try {<br>
     * &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Main.yourFunction3();<br>
     * &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;return null;<br>
     * &emsp;&emsp;&emsp;&emsp;} catch (Exception e) {<br>
     * &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;return Error_Handler.pop_error(e);<br>
     * &emsp;&emsp;&emsp;&emsp;}<br>
     * &emsp;&emsp;&emsp;&emsp;}),<br>
     * &emsp;&emsp;...<br>
     * };<br></code>
     */
    public FunctionInfo(String functionName, Callable<T> function) {

        this.functionName = functionName;
        this.callableFunction = function;
        this.runnableFunction = null;
    }

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
     * &emsp;&emsp;new FunctionInfo<>("yourFunction1", () -> {<br>
     * &emsp;&emsp;&emsp;&emsp;try{<br>
     * &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;return Main.yourFunction1();<br>
     * &emsp;&emsp;&emsp;&emsp;} catch (Exception e) {<br>
     * &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;return Error_Handler.pop_error(e);<br>
     * &emsp;&emsp;&emsp;&emsp;}<br>
     * &emsp;&emsp;&emsp;&emsp;}),<br>
     * &emsp;&emsp;new FunctionInfo<>("yourFunction2", () -> {<br>
     * &emsp;&emsp;&emsp;&emsp;try {<br>
     * &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Main.yourFunction2();<br>
     * &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;return null;<br>
     * &emsp;&emsp;&emsp;&emsp;} catch (Exception e) {<br>
     * &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;return Error_Handler.pop_error(e);<br>
     * &emsp;&emsp;&emsp;&emsp;}<br>
     * &emsp;&emsp;&emsp;&emsp;}),<br>
     * &emsp;&emsp;new FunctionInfo<>("yourFunction3", () ->  {<br>
     * &emsp;&emsp;&emsp;&emsp;try {<br>
     * &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Main.yourFunction3();<br>
     * &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;return null;<br>
     * &emsp;&emsp;&emsp;&emsp;} catch (Exception e) {<br>
     * &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;return Error_Handler.pop_error(e);<br>
     * &emsp;&emsp;&emsp;&emsp;}<br>
     * &emsp;&emsp;&emsp;&emsp;}),<br>
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

    public T call() {
        try {
            if (callableFunction != null) {
                return callableFunction.call();
            } else if ( runnableFunction != null) {
                runnableFunction.run();
            }
        } catch (Exception e) {
            return (T) Error_Handler.pop_error(e);
        }
        return null;
    }
}

