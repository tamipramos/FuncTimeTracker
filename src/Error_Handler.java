public class Error_Handler {
    public static String pop_error(Exception e){
        StackTraceElement[] stackTrace = e.getStackTrace();
        int lineNumber = 0;
        String fileName = "";
        if (stackTrace.length > 0) {
            lineNumber = stackTrace[0].getLineNumber();
            fileName = stackTrace[0].getFileName();
        }
        return ("\u001b[31m" + e.toString() + "\u001b[0m\u001b[37m" + "\n\t\t\t\t\t" + "\u001b[0m\u001b[31m" + Execution_Counter.translation.getErrorFinder() + ": \u001b[0m \u001b[33m" + fileName + "::" + lineNumber + "\u001b[0m");


    }
}
