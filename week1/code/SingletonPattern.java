public class SingletonPattern {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("This is the first message.");

        Logger logger2 = Logger.getInstance();
        logger2.log("This is the second message.");

        if (logger1 == logger2) {
            System.out.println("Both logger instances are the same. Singleton confirmed.");
        } else {
            System.out.println("Different logger instances. Singleton violated.");
        }
    }
}

class Logger {
    private static Logger instance;
    
    private Logger() {
        System.out.println("Logger instance created.");
    }
    
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
    
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}