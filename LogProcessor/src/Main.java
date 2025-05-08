import LogHandler.DebugLogHandler;
import LogHandler.ErrorLogHandler;
import LogHandler.InfoLogHandler;
import LogHandler.LogHandlerInterface;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        LogHandlerInterface logHandlerObject = new InfoLogHandler(new DebugLogHandler(new ErrorLogHandler(null)));
        logHandlerObject.log(LogHandlerInterface.ERROR, "exception");
        logHandlerObject.log(LogHandlerInterface.DEBUG,"need to debug");
        logHandlerObject.log(LogHandlerInterface.INFO, "Justfor info");
    }
}