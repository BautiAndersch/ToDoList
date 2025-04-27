public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(String message) {
        super("ERROR,"+message);
    }
}
