package generators;

import org.json.simple.*;

import java.io.FileWriter;
import java.io.IOException;

public class JSONGenerator {

    public static void main(String[] args) {
        generateJSON();
    }

    // Structure
    public static void generateJSON() {
        JSONObject dataFromContainerFirst = new JSONObject();
        dataFromContainerFirst.put("weight", "500");
        dataFromContainerFirst.put("userId", "1");
        dataFromContainerFirst.put("time", "2020-10-27T11:30:30.634Z"); // Instant time

        JSONObject dataObjectFirst = new JSONObject();
        dataObjectFirst.put("dataFromContainer", dataFromContainerFirst);

        JSONArray dataFromContainerList = new JSONArray();
        dataFromContainerList.add(dataObjectFirst);

        // Write JSON file
        try (FileWriter file = new FileWriter("dataFromContainer.json")) {
            file.write(dataFromContainerList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
