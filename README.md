# FuncTimeTracker


FuncTimeTracker is a <img src="https://github.com/devicons/devicon/blob/master/icons/java/java-original-wordmark.svg" title="Java" alt="Java" width="40" height="40"/>&nbsp; application designed to measure the execution time of individual functions in a program. It provides a straightforward way to measure and analyze the performance of each function, which can be useful for identifying bottlenecks and optimizing code.

## Features

- Calculates the execution time of each function individually.
- Supports functions that return a value (`Callable`) and void functions (`Runnable`).
- Provides detailed information about the execution time of each function, including its name and result.
```java
  [✓]  Runtime:				1,003000 seconds
  [name]				yourFunction1
  [result]				42
  [✓]  Runtime:				2,004000 seconds
  [name]				yourFunction2
  [result]				void
  [X]  Runtime:	        		0,008000 seconds
  [name]				yourFunction3
  [result]				java.lang.RuntimeException: Unnable to simulate function
                                        An error occurred here:  Main.java::55
  [*] Total execution time:		3,015000  seconds
```
- Compatible with multiple languages, with initial support for English.
```java
public enum Languages {
    ESP,
    ENG,
    GER
}
...
class Execution_Counter {
    private static final Languages LANG = Languages.ENG;
    ...
}

```

## Usage

To use FuncTimeTracker, follow these steps:

1. Define the functions you want to measure in your program as `FunctionInfo` objects.
2. Group these functions into a `FunctionInfo<?>[]` array.
3. Call the `exec_function()` method of `Execution_Counter`, passing the array of functions as an argument.

Below is an example of how to use FuncTimeTracker

## Example

Here's an example of how FuncTimeTracker could be used in a Java program:


```java
import java.util.concurrent.Callable;

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
            // Add more objects here as needed
        };

        Execution_Counter.exec_function(functionArray);
    }
    
    /////////////////////////////////////////////////////////////////////
    //                      EXAMPLE FUNCTIONS                          //
    // we declare "throws Exception" to catch the future Exception in  //
    //   Error_Handler.java with its function pop_error(Exception e)   //
    /////////////////////////////////////////////////////////////////////
    
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
```

