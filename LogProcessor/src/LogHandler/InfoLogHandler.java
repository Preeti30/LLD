package LogHandler;

public class InfoLogHandler extends  LogHandlerInterface{
    public InfoLogHandler(LogHandlerInterface nextLogHandler)
    {
        super(nextLogHandler);
    }

    public void log(int level, String message)
    {
        if(level== INFO)
        {
            System.out.println("INFO:" + message);
        }
        else
        {
            super.log(level, message);
        }
    }
}
