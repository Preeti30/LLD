package LogHandler;

public abstract class LogHandlerInterface {

    public static int INFO =1;
    public static int ERROR = 2;
    public static int DEBUG = 3;

    LogHandlerInterface nextlogHandlerInterface;
    LogHandlerInterface(LogHandlerInterface nextHandler)
    {
        this.nextlogHandlerInterface = nextHandler;
    }

    public void log(int loglevel, String message)
    {
        if(nextlogHandlerInterface!=null){
            nextlogHandlerInterface.log(loglevel, message);
        }
    }

}
