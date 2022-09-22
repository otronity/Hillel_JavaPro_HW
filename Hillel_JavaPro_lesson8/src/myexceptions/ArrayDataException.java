package myexceptions;

public class ArrayDataException extends Exception {

    String message;
    public ArrayDataException(String m) {
        this.message = m;
    }

    public String getMessage(){
        return this.message;
    }
}
