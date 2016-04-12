package Base.Command;

import Base.CommandExit;
import Base.ConsoleHalper;
import Base.IniHalper;
import Base.PhoneBook;

class CommandAdd implements Command  {
    @Override
    public void execute() throws Exception {
        String[] arguments;
        ConsoleHalper.write("Введите значения записи в формате - Номер Имя");
        while (true) {
            try {
                arguments = ConsoleHalper.getComand();
                if (arguments[0].charAt(0) == '+')
                Long.parseLong(arguments[0].substring(1));
                else
                    Long.parseLong(arguments[0].substring(1));
                if (PhoneBook.clients.containsKey(arguments[1])) {
                    String bufer = PhoneBook.clients.get(arguments[1]) + ", " + arguments[0];
                    PhoneBook.clients.put(arguments[1], bufer);
                }else
                PhoneBook.clients.put(arguments[1], arguments[0]);
                ConsoleHalper.write("Запись успешно добавлена");
                break;
            } catch (CommandExit e) {
                throw e;
            } catch (Exception e) {
                ConsoleHalper.write("Введены неверные значения");
            }
        }
        IniHalper.save();
    }
}
