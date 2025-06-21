public class Test {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("This is a test log message.");
        
        Logger anotherLogger = Logger.getInstance();
        anotherLogger.log("This is another test log message.");
        
        // Check if both instances are the same
        System.out.println("Are both logger instances the same? " + (logger == anotherLogger));
    }
}