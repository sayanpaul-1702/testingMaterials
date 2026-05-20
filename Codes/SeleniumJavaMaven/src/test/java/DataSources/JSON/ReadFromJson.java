package DataSources.JSON;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromJson {
    public static void main(String[] args) throws IOException, ParseException {
        FileReader reader = new FileReader(System.getProperty("user.dir") + "\\src\\test\\java\\DataSources\\JSON\\data.json");
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(reader);

        JSONArray bookingDetailsArray = (JSONArray) obj.get("BookingDetails");
        JSONObject details = (JSONObject) bookingDetailsArray.get(0);
        System.out.println(details.get("ContactNumber"));
    }
}
