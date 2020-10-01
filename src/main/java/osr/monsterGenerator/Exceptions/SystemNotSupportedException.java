package osr.monsterGenerator.Exceptions;

public class SystemNotSupportedException extends RuntimeException {
    public SystemNotSupportedException(String message) {
        super(message + " is currently not supported.");
    }
}
