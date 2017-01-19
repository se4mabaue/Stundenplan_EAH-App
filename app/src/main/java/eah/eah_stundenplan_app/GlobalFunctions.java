package eah.eah_stundenplan_app;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by Martin Bauer on 11.01.2017.
 */

public class GlobalFunctions {

    /*
    Die Funktion liest die gewünschte Datei ein.
    */
    public final static String getStringFromBufferedReader(BufferedReader bufferedReader) throws IOException
    {
        String line = "";
        String bufferedString = "";

        while (line != null)
        {
            line = bufferedReader.readLine();
            if (line != null)
            {
                bufferedString += line;
            }
        }
        return bufferedString;
    }

}
