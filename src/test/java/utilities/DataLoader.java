package utilities;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataLoader {
    static String val = null;

    public static String getData(String path, String value) {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        String completePath = "src/test/resources/testdata/"+path;

        try (FileReader reader = new FileReader(completePath))
        {
            Object obj = jsonParser.parse(reader);
            JSONObject o = (JSONObject) obj;
            val =o.get(value).toString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return val;
    }

}
