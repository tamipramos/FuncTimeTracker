# FuncTimeTracker

FuncTimeTracker is a Java application designed to measure the execution time of individual functions in a program. It provides a straightforward way to measure and analyze the performance of each function, which can be useful for identifying bottlenecks and optimizing code.

## Features

- Calculates the execution time of each function individually.
- Supports functions that return a value (`Callable`) and void functions (`Runnable`).
- Provides detailed information about the execution time of each function, including its name and result.
- Compatible with multiple languages, with initial support for German.

## Usage

To use FuncTimeTracker, follow these steps:

1. Define the functions you want to measure in your program as `FunctionInfo` objects.
2. Group these functions into a `FunctionInfo<?>[]` array.
3. Call the `exec_function()` method of `Execution_Counter`, passing the array of functions as an argument.

Below is an example of how to use FuncTimeTracker:

```java
FunctionInfo<?>[] functionArray = new FunctionInfo<?>[] {
    new FunctionInfo<>("function1", () -> yourFunction1()),
    new FunctionInfo<>("function2", () -> yourFunction2()),
    // Add more functions here as needed
};

Execution_Counter.exec_function(functionArray);
```

## Example

Here's an example of how FuncTimeTracker could be used in a Java program:


```java
import java.util.concurrent.Callable;

public class Main {

    public static void main(String[] args) {
        FunctionInfo<?>[] functionArray = new FunctionInfo<?>[] {
            new FunctionInfo<>("function1", () -> yourFunction1()),
            new FunctionInfo<>("function2", () -> yourFunction2()),
            // Add more functions here as needed
        };

        Execution_Counter.exec_function(functionArray);
    }

    public static int yourFunction1() throws Exception {
        // we use throws Exception to handle the Exception in other place.
        // Simulate a function that takes time to execute
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 42;
    }

    public static void yourFunction2() throws Exception {
        // we use throws Exception to handle the Exception in other place.
        // Simulate a void function
        System.out.println("Executing function 2");
    }
}
```

