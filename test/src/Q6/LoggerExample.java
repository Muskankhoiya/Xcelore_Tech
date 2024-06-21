package Q6;
interface Logger{
    void log(String message);

    static Logger createLogger(){
        return (Logger) new LoggerExample();
    }
}
public class LoggerExample  implements  Logger{


    @Override
    public void log(String message) {
        System.out.println("Log message" + message);

    }
}
