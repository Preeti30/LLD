package LogHandler;

public class DebugLogHandler extends LogHandlerInterface{

    public DebugLogHandler(LogHandlerInterface nextLogHandler)
    {
        super(nextLogHandler);
    }

    public void log(int level, String message)
    {
        if(level == DEBUG)
        {
            System.out.println("DEBUG:" + message);
        }
        else
        {
            super.log(level, message);
        }
    }
}
