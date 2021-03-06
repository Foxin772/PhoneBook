package Base;

import Base.Exceptions.CommandExit;
import Base.Exceptions.GoToMenuException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleHalper {

    public static void write(String x)
    {
        System.out.println(x);
        System.out.println("********************");
    }

    public static String read() throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, "Cp866"));
        String read = reader.readLine();
        System.out.println("********************");
        if (read.equalsIgnoreCase("выход"))
        throw new CommandExit();
        else if (read.equalsIgnoreCase("меню"))
            throw new GoToMenuException();
        else
            return read;
    }

    public static String getState() throws Exception
    {
        ConsoleHalper.write("Введите команду");
        return read().trim();
    }

    public static String getAnswer() throws Exception
    {
        return read().trim();
    }

    public static String[] getComand() throws Exception
    {
        return read().split(" ");
    }
}
