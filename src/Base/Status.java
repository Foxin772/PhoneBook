package Base;

import java.io.IOException;

public enum Status {

    ADD,
    SELECT,
    DELETE,
    WRITE;

    public static Status getStatus(String x) throws IOException
    {
        switch (x.toUpperCase())
        {
            case "ДОБАВИТЬ":
                return ADD;
            case "НАЙТИ":
                return SELECT;
            case "УДАЛИТЬ":
                return DELETE;
            case "ВЫВЕСТИ ВСЕ ДАННЫЕ":
                return WRITE;
        }
        throw new IOException();
    }
}
