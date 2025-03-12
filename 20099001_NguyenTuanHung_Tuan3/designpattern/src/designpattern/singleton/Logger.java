package designpattern.singleton;

public class Logger {
    private static Logger instance;
    private java.util.List<String> logMessages;


    private Logger() {
        logMessages = new java.util.ArrayList<>();
    }

 
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) { 
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        logMessages.add(message);
        System.out.println("Logged: " + message);
    }

    public java.util.List<String> getLogMessages() {
        return logMessages;
    }

  
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("Thông báo 1");

        Logger logger2 = Logger.getInstance();
        logger2.log("Thông báo 2");

        System.out.println(logger1.getLogMessages()); 
        System.out.println(logger1 == logger2);       
    }
}
