package Base.Command;

import Base.CommandExit;
import Base.ConsoleHalper;
import Base.IniHalper;
import Base.PhoneBook;

import java.util.HashMap;
import java.util.Map;

class CommandDelet implements Command {
    @Override
    public void execute() throws CommandExit {
        if (PhoneBook.clients.size() == 0)
        {
            ConsoleHalper.write("Нет записей");
            return;
        }
         ConsoleHalper.write("Введите название записии");
        String[] arguments;
        while (true) {
            try {
                arguments = ConsoleHalper.getComand();
                if (!PhoneBook.clients.containsKey(arguments[0]) && !PhoneBook.clients.containsValue(arguments[0]))
                    throw new Exception();
                Map<String, String> copy = new HashMap<>(PhoneBook.clients);
                int i = 0;
                for (Map.Entry<String, String> map : PhoneBook.clients.entrySet())
                {
                    if (arguments[0].equals(map.getKey()) || arguments[0].equals(map.getValue())) {
                        copy.remove(map.getKey());
                        i++;
                    }
                }
                PhoneBook.clients = copy;
                if (i == 0)
                    throw new Exception();
                else
                ConsoleHalper.write("Запись успешно удалена");
                break;
            }catch (CommandExit e) {
                throw e;
            } catch (Exception e) {
                ConsoleHalper.write("Введен неверный контакт");
            }
        }
        IniHalper.save();
    }
}