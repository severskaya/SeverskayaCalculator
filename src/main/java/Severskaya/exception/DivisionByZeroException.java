package Severskaya.exception;

public class DivisionByZeroException extends Exception {

    public DivisionByZeroException(){}

    public DivisionByZeroException(String msg){
        super(msg); //Exception(msg)
    }
}
