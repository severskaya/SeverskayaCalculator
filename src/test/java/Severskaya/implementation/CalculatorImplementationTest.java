package Severskaya.implementation;

import Severskaya.exception.DivisionByZeroException;
import Severskaya.implementation.CalculatorImplementation;
import Severskaya.interfaces.MathSymbolInterface;
import org.junit.*;
import org.mockito.*;

import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CalculatorImplementationTest {
    private CalculatorImplementation calcImplementation;

    @Mock
    private static Map<String, MathSymbolInterface> map;

    @Mock
    private MathSymbolInterface msi;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        calcImplementation = new CalculatorImplementation();
    }

    @Test
    public void plusOperationShouldCombineTwoDoubles() throws DivisionByZeroException {
        //Arrange
        when(map.get("+")).thenReturn(msi);
        double expectedResult = 10;
        when(msi.calculateOperation(5,5)).thenReturn(expectedResult);
        CalculatorImplementation.operations = map;

        //Act
        double result = calcImplementation.calculate(5,5,"+");

        //Assert
        verify(map).get("+");
        verify(msi).calculateOperation(5,5);
        assertEquals("Operation with Plus wasn't finished successful", expectedResult, result, 1e-10);
    }

    @Test
    public void minusOperationShouldSubtractTwoDoubles() throws DivisionByZeroException{
        //Arrange
        when(map.get("-")).thenReturn(msi);
        double expectedResult = 10;
        when(msi.calculateOperation(20, 10)).thenReturn(expectedResult);
        CalculatorImplementation.operations = map;

        //Act
        double result = calcImplementation.calculate(20, 10, "-");

        //Assert
        verify(map).get("-");
        verify(msi).calculateOperation(20, 10);
        assertEquals("Operation with Minus wasn't finished successful", expectedResult, result, 1e-10);
    }

    @Test
    public void multiplyOperationShouldMultiplyTwoDoubles() throws DivisionByZeroException{
        //Arrange
        when(map.get("*")).thenReturn(msi);
        double expectedResult = 20;
        when(msi.calculateOperation(10, 2)).thenReturn(expectedResult);
        CalculatorImplementation.operations = map;

        //Act
        double result = calcImplementation.calculate(10, 2, "*");

        //Assert
        Mockito.verify(map).get("*");
        Mockito.verify(msi).calculateOperation(10, 2);
        assertEquals("Operation with Multiply wasn't finished successful", expectedResult, result, 1e-10);
    }

    @Test
    public void divisionOperationShouldDivideTwoDoubles() throws DivisionByZeroException{
        //Arrange
        when(map.get("/")).thenReturn(msi);
        double expectedResult = 5;
        when(msi.calculateOperation(10, 2)).thenReturn(expectedResult);
        CalculatorImplementation.operations = map;

        //Act
        double result = calcImplementation.calculate(10, 2, "/");

        //Assert
        verify(map).get("/");
        verify(msi).calculateOperation(10, 2);
        assertEquals("Operation with Division wasn't finished successful", expectedResult, result, 1e-10);
    }

    @Test(expected = DivisionByZeroException.class)
    public void divisionByZeroShouldThrowException() throws DivisionByZeroException{
        double result = calcImplementation.calculate(10, 0, "/");
    }

    @Test
    public void getHelpMethodShouldReturnStringWithOperatios(){
        //Act
        String result = calcImplementation.getHelp();

        //Assert
        assertEquals("Ошибка в getHelp", "+, -, *, /", result);
    }
}
