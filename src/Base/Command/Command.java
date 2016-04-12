package Base.Command;

import java.io.InterruptedIOException;

interface Command {
    void execute() throws Exception;
}
