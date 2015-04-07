package Severskaya.implementation;

import Severskaya.exception.DivisionByZeroException;
import Severskaya.interfaces.CalculatorInterface;
import Severskaya.interfaces.MathSymbolInterface;

import java.util.HashMap;
import java.util.Map;

public class CalculatorImplementation implements CalculatorInterface {
    private static final String HELP_MESSAGE = "+, -, *, /";
    public static Map<String, MathSymbolInterface> operations;

    public CalculatorImplementation(){
        createOperationsMap();
    }

    public double calculate(double firstNumber, double secondNumber, String mathSymbol) throws DivisionByZeroException {

        if (secondNumber == 0 && mathSymbol.equals("/")){
            throw new DivisionByZeroException("Деление на 0 невозможно");
        }

        MathSymbolInterface neededOperation = operations.get(mathSymbol);
        return neededOperation.calculateOperation(firstNumber, secondNumber);
    }

    public String getHelp(){
        return HELP_MESSAGE;
    }

    public static void createOperationsMap(){
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

}
