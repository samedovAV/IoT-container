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
        dataFromContainerFirst.put("daysRemaining", "3");

        JSONObject dataObjectFirst = new JSONObject();
        dataObjectFirst.put("dataFromContainer", dataFromContainerFirst);

        JSONObject dataFromContainerSecond = new JSONObject();
        dataFromContainerSecond.put("weight", "500");
        dataFromContainerSecond.put("userId", "1");
        dataFromContainerSecond.put("time", "2020-10-28T11:30:30.634Z"); // Instant time
        dataFromContainerSecond.put("daysRemaining", "2");

        JSONObject dataObjectSecond = new JSONObject();
        dataObjectSecond.put("dataFromContainer", dataFromContainerSecond);

        JSONArray dataFromContainerList = new JSONArray();
        dataFromContainerList.add(dataObjectFirst);
        dataFromContainerList.add(dataObjectSecond);

        // Write JSON file
        try (FileWriter file = new FileWriter("dataFromContainer.json")) {
            file.write(dataFromContainerList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
