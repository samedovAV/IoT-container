package parsers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONParserIoT {

    public static void main(String[] args) throws IOException {
        parseJSON();
    }

    public static void parseJSON() throws IOException {
        JSONParser jsonParser = new JSONParser();

        FileWriter file = new FileWriter("dataFromContainer.txt");

        try (FileReader reader = new FileReader("dataFromContainer.json")) {
            Object obj = jsonParser.parse(reader);

            JSONArray dataFromContainerList = (JSONArray) obj;

            dataFromContainerList.forEach(data -> {
                parseDataContainerObject((JSONObject) data, file);
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void parseDataContainerObject(JSONObject data, FileWriter file) {

        JSONObject dataFromContainerObject = (JSONObject) data.get("dataFromContainer");

        String daysRemaining = (String) dataFromContainerObject.get("daysRemaining");
        String weight = (String) dataFromContainerObject.get("weight");
        String time = (String) dataFromContainerObject.get("time");
        String userId = (String) dataFromContainerObject.get("userId");

        try {
            file.write(daysRemaining + "\n");
            file.write(weight + "\n");
            file.write(time + "\n");
            file.write(userId + "\n");
            file.write("\n");
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
