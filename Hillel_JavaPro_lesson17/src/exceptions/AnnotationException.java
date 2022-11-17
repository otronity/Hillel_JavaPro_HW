package exceptions;

public class AnnotationException extends Exception {

    String message;

    public AnnotationException(String message) {
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }

}
