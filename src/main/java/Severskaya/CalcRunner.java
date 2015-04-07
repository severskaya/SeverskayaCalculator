package Severskaya;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;


public class CalcRunner {
    public void exitFromCalc(){
        System.out.println("Вы вышли из программы Calculator");
        System.exit(0);
    }

    private static String getProperty(String propertyKey){
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("src/main/resources/CalcMessages.properties");
            property.load(fis);
        } catch (IOException e){
            System.out.println("Файл свойств CalcMessages.properties не найден");
        }
        return property.getProperty(propertyKey);
    }

    public static void main(String[] args) {

        final String HELP_COMMAND = "h";
        final String EXIT_COMMAND = "q";
        final String COUNT_COMMAND = "c";

        String mathSymbol;
        String userInput;

        double firstNumber;
        double secondNumber;
        double result;

        CalculatorImplementation calcImp = new CalculatorImplementation();
        CalcRunner calcRunner = new CalcRunner();

        while ( true ){
            System.out.println(getProperty("DEFAULT_MESSAGE"));
            Scanner sc = new Scanner(System.in );
            userInput = sc.next();
            userInput = userInput.toLowerCase();

            switch (userInput) {
                case HELP_COMMAND:
                    System.out.println(calcImp.getHelp());
                    break;
                case COUNT_COMMAND:
                    System.out.println(getProperty("CC_FIRST_NUMBER"));
                    firstNumber = sc.nextDouble();
                    System.out.println(getProperty("CC_MATH_SYMBOL"));
                    mathSymbol = sc.next();
                    System.out.println(getProperty("CC_SECOND_NUMBER"));
                    secondNumber = sc.nextDouble();

                    try {
                        result = calcImp.calculate(firstNumber, secondNumber, mathSymbol);
                        System.out.println(getProperty("CC_YOUR_RESULT")+ " " + result);
                    } catch (DivisionByZeroException dbz) {
                        System.err.println(dbz.getMessage());
                    }
                    break;
                case EXIT_COMMAND:
                    calcRunner.exitFromCalc();
                    break;
                default:
                    System.out.println(getProperty("EXIT_ERROR_MESSAGE") + getProperty("DEFAULT_MESSAGE"));
            }
        }

    }
}
