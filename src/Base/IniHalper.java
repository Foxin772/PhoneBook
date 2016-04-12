package Base;


import java.io.*;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

public class IniHalper {

    private IniHalper() {
    }

    private final static String fileName = "property.ini";

    private static FileInputStream fileInputStream;

    private static FileOutputStream fileOutputStream;

    private static Properties properties = new Properties();

    public static void save()
    {
        try {
            fileOutputStream = new FileOutputStream(fileName);
            OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream, "Cp866");
            for (Map.Entry<String, String> map : PhoneBook.clients.entrySet())
            {
                properties.put(map.getKey(), map.getValue());
            }
            properties.store(writer, "PhoneBook");
            fileOutputStream.close();
        } catch (Exception e) {
            ConsoleHalper.write("Ошибка записи в файл");
        }
    }


    public static void load()
    {
        try {

            fileInputStream = new FileInputStream(fileName);
            InputStreamReader reader = new InputStreamReader(fileInputStream, "Cp866");
            properties.load(reader);
            Enumeration enumeration = properties.keys();

            while (enumeration.hasMoreElements())
            {
                String key = enumeration.nextElement().toString();
                PhoneBook.clients.put(key, properties.getProperty(key));
            }
            fileInputStream.close();
        } catch (Exception e) {
            ConsoleHalper.write("Ошибка чтения из файла");
        }
    }
}
