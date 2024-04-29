public class Main {
    public static void main(String[] args) {
        FunctionInfo<?>[] functionArray = new FunctionInfo<?>[] {
 //               new FunctionInfo<>("calc", () -> Suma.calc(100000)),
 //               new FunctionInfo<>("sumar", () -> Suma.sumar(12,13)),
 //               new FunctionInfo<>("calc_2",  () -> Suma.calc(500000)),
 //               new FunctionInfo<>("calc_output",  () -> Suma.calc(1000000)),
 //               new FunctionInfo<>("calc_error", Suma::calc_error)
        };
        Execution_Counter.exec_function(functionArray);
    }


}
