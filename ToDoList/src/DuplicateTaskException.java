public class DuplicateTaskException extends RuntimeException {
    public DuplicateTaskException(String message) {
        super("ERROR,"+message);
    }
}
