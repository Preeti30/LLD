package LogHandler;

public class ErrorLogHandler extends LogHandlerInterface{

    public ErrorLogHandler(LogHandlerInterface nextLogHandler)
    {
        super(nextLogHandler);
    }

    public void log(int level, String message)
    {
        if(level == ERROR)
            System.out.println("ERROR"+ message);
        else
        {
            super.log(level, message);
        }
    }
}
