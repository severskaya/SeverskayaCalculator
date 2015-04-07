package Severskaya.interfaces;

import Severskaya.exception.DivisionByZeroException;

public interface CalculatorInterface {

     double calculate(double firstNumber, double secondNumber, String mathSymbol) throws DivisionByZeroException;
     String getHelp();

}