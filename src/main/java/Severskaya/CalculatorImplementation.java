package Severskaya;

import java.util.HashMap;
import java.util.Map;

public class CalculatorImplementation implements CalculatorInterface{
    private static final String HELP_MESSAGE = "+, -, *, /";

    Map<String, MathSymbolInterface> operations;

    public CalculatorImplementation (){
        operations = new HashMap<>();
        operations.put("-", new MathSymbolInterface() {
            @Override
            public double calculateOperation(double a, double b) {
                return a - b;
            }
        });
        operations.put("+", new MathSymbolInterface() {
            @Override
            public double calculateOperation(double a, double b) {
                return a + b;
            }
        });
        operations.put("*", new MathSymbolInterface() {
            @Override
            public double calculateOperation(double a, double b) {
                return a * b;
            }
        });
        operations.put("/", new MathSymbolInterface() {
            @Override
            public double calculateOperation(double a, double b) {
                return a / b;
            }
        });

    }

    public double calculate(double firstNumber, double secondNumber, String mathSymbol) throws DivisionByZeroException{

        if (secondNumber == 0 && mathSymbol.equals("/")){
            throw new DivisionByZeroException("Деление на 0 невозможно");
        }

        MathSymbolInterface neededOperation = operations.get(mathSymbol);
        return neededOperation.calculateOperation(firstNumber, secondNumber);
    }

    public String getHelp(){
        return HELP_MESSAGE;
    }


}
