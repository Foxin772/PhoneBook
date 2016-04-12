package Base.Command;

import Base.ConsoleHalper;
import Base.PhoneBook;

import java.util.Map;

class CommandWrite implements Command {

    @Override
    public void execute() throws Exception {
        for (Map.Entry<String, String> map : PhoneBook.clients.entrySet())
        {
            ConsoleHalper.write(map.getKey() + " " + map.getValue());
        }
    }
}
