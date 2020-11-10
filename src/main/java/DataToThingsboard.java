import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DataToThingsboard {
    // curl -v -X POST -d "{\"weight\":500, \"userId\":5}" https://demo.thingsboard.io/api/v1/ltX7U9qMMxHiBVax3tP5/telemetry --header "Content-Type:application/json"
    public static void main(String[] args) throws IOException, InterruptedException {
        for (int i = 0; i < 10; i++) {
            int weight = (int)(Math.random() * (1000 - 100 + 1) + 100);
            int userId = (int)(Math.random() * (10 - 1 + 1) + 1);
            String command =
                    "curl -v -X POST -d \"{\\\"weight\\\":" + weight + ", \\\"userId\\\":" + userId + "}\" https://demo.thingsboard.io/api/v1/ltX7U9qMMxHiBVax3tP5/telemetry --header \"Content-Type:application/json\"";
            Process process = Runtime.getRuntime().exec(command);
            process.getInputStream();
            TimeUnit.SECONDS.sleep(5);
        }
    }
}

//        curl -v -X GET http://demo.thingsboard.io/api/v1/ltX7U9qMMxHiBVax3tP5/attributes?clientKeys=attribute1,attribute2&sharedKeys=shared1,shared2);

