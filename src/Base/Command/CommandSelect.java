package Base.Command;


import Base.CommandExit;
import Base.ConsoleHalper;
import Base.PhoneBook;

import java.util.Map;

class CommandSelect implements Command {
    @Override
    public void execute() throws CommandExit{
        if (PhoneBook.clients.size() == 0)
        {
            ConsoleHalper.write("Нет записей");
            return;
        }
        ConsoleHalper.write("Введите искомое значение");
        String[] arguments;
        while (true) {
            try {
                arguments = ConsoleHalper.getComand();
                String argument = arguments[0].toLowerCase();
                int i = 0;
                for (Map.Entry<String, String> map : PhoneBook.clients.entrySet())
                {
                    String one = map.getKey().toLowerCase();
                    if (one.contains(argument) || map.getValue().contains(argument)) {
                        ConsoleHalper.write(map.getKey() + " " + map.getValue());
                        i++;
                    }
                }
                if (i > 0)
                ConsoleHalper.write("Все данные выведены");
                else
                ConsoleHalper.write("Не найдено");
                break;
            }catch (CommandExit e) {
                throw e;
            }catch (GoToMenuException e)
            {}
            catch (Exception e) {
                ConsoleHalper.write("Введен неверный контакт");
            }
        }
    }
}
