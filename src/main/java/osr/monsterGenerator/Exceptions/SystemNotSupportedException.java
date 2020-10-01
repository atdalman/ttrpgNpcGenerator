package osr.monsterGenerator.Exceptions;

public class SystemNotSupportedException extends RuntimeException {
    public SystemNotSupportedException(String message) {
        super(message + " is currently not supported.  Please check your spelling, and try again if you believe this " +
                "to be in error.");
    }
}
