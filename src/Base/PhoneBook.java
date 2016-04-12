package Base;

import Base.Command.Comand;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    public static Map<String, String> clients = new HashMap<>();
    public static void main(String[] args) throws Exception
    {
        ConsoleHalper.write("Возможные команды(не зависят от регистра): Добавить, Найти, Удалить, Вывести все данные");
        IniHalper.load();
        while (true)
        {
            try {
                Comand.execute(Status.getStatus(ConsoleHalper.getState()));
            }catch (CommandExit e)
            {
                ConsoleHalper.write("Пока))");
                break;
            }catch (Exception e)
            {
                ConsoleHalper.write("Введена неверная команда");
            }
        }
        ConsoleHalper.read();
    }



}
