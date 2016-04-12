package Base.Command;

import Base.Status;

import java.util.HashMap;
import java.util.Map;

public final class Comand
{

    private static Map<Status, Command> commandMap = new HashMap<>();
    static
    {
        commandMap.put(Status.ADD, new CommandAdd());
        commandMap.put(Status.SELECT, new CommandSelect());
        commandMap.put(Status.DELETE, new CommandDelet());
        commandMap.put(Status.WRITE, new CommandWrite());
    }
    final public static void execute(Status base) throws Exception {
        commandMap.get(base).execute();
    }

    private Comand()
    {

    }
}
