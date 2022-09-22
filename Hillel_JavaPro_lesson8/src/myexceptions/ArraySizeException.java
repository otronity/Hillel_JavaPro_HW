package myexceptions;

public class ArraySizeException extends Exception{

    String message;

    public ArraySizeException(String m) {
        this.message = m;
    }

    public String getMessage(){
        return this.message;
    }
}
