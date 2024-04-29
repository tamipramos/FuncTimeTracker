public class Main {
    public static void main(String[] args) {
        FunctionInfo<?>[] functionArray = new FunctionInfo<?>[] {
                new FunctionInfo<>("yourFunction1", () -> {
                    try{
                        return Main.yourFunction1();
                    } catch (Exception e) {
                        return Error_Handler.pop_error(e);
                    }
                }),
                new FunctionInfo<>("yourFunction2", () -> {
                    try {
                        Main.yourFunction2();
                        return null;
                    } catch (Exception e) {
                        return Error_Handler.pop_error(e);
                    }
                }),
                new FunctionInfo<>("yourFunction3", () ->  {
                    try {
                        Main.yourFunction3();
                        return null;
                } catch (Exception e) {
                        return Error_Handler.pop_error(e);
                    }
                }),
        };
        Execution_Counter.exec_function(functionArray);
    }


    // EXAMPLES
    public static int yourFunction1() throws Exception{
        try {
            // Simulate a function that takes time to execute
            Thread.sleep(1000);
            return 42;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return -1;
        }
    }

    public static void yourFunction2() throws Exception {
        try {
            // Simulate a void function
            Thread.sleep(2000);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void yourFunction3() throws Exception {
        // Simulate a void function with Exception
        throw new RuntimeException("Unnable to simulate function");

    }

}
