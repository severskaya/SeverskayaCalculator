package Severskaya;

import org.junit.*;
import org.mockito.*;

import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CalculatorImplementationTest {
    private CalculatorImplementation calcImplementation;

    @Mock
    private Map<String, MathSymbolInterface> map;

    @Mock
    private MathSymbolInterface msi;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        calcImplementation = new CalculatorImplementation();
    }

    @Test
    public void mockTestForPlus() throws DivisionByZeroException{
        //Arrange
        when(map.get("+")).thenReturn(msi);
        double expectedResult = 10;
        Mockito.when(msi.calculateOperation(5,5)).thenReturn(expectedResult);
        calcImplementation.operations = map;

        //Act
        double result = calcImplementation.calculate(5,5,"+");

        //Assert
        Mockito.verify(map).get("+");
        Mockito.verify(msi).calculateOperation(5,5);
        assertEquals("Operation with Plus wasn't finished successful", expectedResult, result, 1e-10);
    }

    @Test
    public void mockTestForMinus() throws DivisionByZeroException{
        //Arrange
        when(map.get("-")).thenReturn(msi);
        double expectedResult = 10;
        Mockito.when(msi.calculateOperation(20, 10)).thenReturn(expectedResult);
        calcImplementation.operations = map;

        //Act
        double result = calcImplementation.calculate(20, 10, "-");

        //Assert
        Mockito.verify(map).get("-");
        Mockito.verify(msi).calculateOperation(20, 10);
        assertEquals("Operation with Minus wasn't finished successful", expectedResult, result, 1e-10);
    }

    @Test
    public void mockTestForMultiply() throws DivisionByZeroException{
        //Arrange
        when(map.get("*")).thenReturn(msi);
        double expectedResult = 20;
        Mockito.when(msi.calculateOperation(10, 2)).thenReturn(expectedResult);
        calcImplementation.operations = map;

        //Act
        double result = calcImplementation.calculate(10, 2, "*");

        //Assert
        Mockito.verify(map).get("*");
        Mockito.verify(msi).calculateOperation(10, 2);
        assertEquals("Operation with Multiply wasn't finished successful", expectedResult, result, 1e-10);
    }

    @Test
    public void mockTestForDivision() throws DivisionByZeroException{
        //Arrange
        when(map.get("/")).thenReturn(msi);
        double expectedResult = 5;
        Mockito.when(msi.calculateOperation(10, 2)).thenReturn(expectedResult);
        calcImplementation.operations = map;

        //Act
        double result = calcImplementation.calculate(10, 2, "/");

        //Assert
        Mockito.verify(map).get("/");
        Mockito.verify(msi).calculateOperation(10, 2);
        assertEquals("Operation with Division wasn't finished successful", expectedResult, result, 1e-10);
    }

    @Test(expected = DivisionByZeroException.class)
    public void checkCalculatorFunctionDivisionException() throws DivisionByZeroException{
        double result = calcImplementation.calculate(10, 0, "/");
    }

    @Test
    public void checkCalculatorGetHelp(){
        //Act
        String result = calcImplementation.getHelp();

        //Assert
        assertEquals("Ошибка в getHelp", "+, -, *, /", result);
    }
}
