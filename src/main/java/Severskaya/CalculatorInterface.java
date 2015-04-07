package Severskaya;

public interface CalculatorInterface {

    public double calculate(double firstNumber, double secondNumber, String mathSymbol) throws DivisionByZeroException;
    public String getHelp();

}