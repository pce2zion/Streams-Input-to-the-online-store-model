package Exceptions;

public class OutofStockException extends RuntimeException{
    public OutofStockException(String msg){
        super(msg);
    }
}
