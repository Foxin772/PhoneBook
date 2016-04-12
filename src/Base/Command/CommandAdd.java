package Base.Command;

import Base.CommandExit;
import Base.ConsoleHalper;
import Base.IniHalper;
import Base.PhoneBook;

class CommandAdd implements Command  {
    @Override
    public void execute() throws Exception {
        String[] arguments;
        ConsoleHalper.write("Введите значения записи в формате - Имя Номер");
        while (true) {
            try {
                arguments = ConsoleHalper.getComand();
                if (arguments[1].charAt(0) == '+')
                Long.parseLong(arguments[1].substring(1));
                else
                    Long.parseLong(arguments[1]);
                if (PhoneBook.clients.containsKey(arguments[0])) {
                    String bufer = PhoneBook.clients.get(arguments[0]) + ", " + arguments[1];
                    PhoneBook.clients.put(arguments[0], bufer);
                }else
                    PhoneBook.clients.put(arguments[0], arguments[1]);
                ConsoleHalper.write("Запись успешно добавлена");
                ConsoleHalper.write("Добавить еще запись? (Да/Нет)");
                if(ConsoleHalper.getAnswer().equalsIgnoreCase("нет"))
                    break;
                else
                    ConsoleHalper.write("Введите значения записи в формате - Имя Номер");
            } catch (CommandExit e) {
                throw e;
            }catch (GoToMenuException e)
            {throw e;}
            catch (Exception e) {
                ConsoleHalper.write("Введены неверные значения");
            }
        }
        IniHalper.save();
    }
}