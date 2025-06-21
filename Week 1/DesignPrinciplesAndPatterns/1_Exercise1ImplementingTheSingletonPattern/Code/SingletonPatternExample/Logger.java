
public class Logger {

    private static Logger instance;

    private Logger() {
        // Private constructor to prevent instantiation
        System.out.println("Logger instance created");
    }

    // Static method to get the singleton instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Logging method for demonstration
    public void log(String message) {
        System.out.println("Log message: " + message);
    }
}
