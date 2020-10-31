package generators;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HTMLGenerator {

    public static void main(String[] args) throws IOException {
        generateHTML();
    }

    public static void generateHTML() throws IOException {
        File file = new File("dataFromContainer.html");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));

        bw.write("<html><body>");
        bw.write("<dataFromContainer>");
        bw.write("<time>2020-10-29T11:30:30.634Z</time>" +
                "<weight>540</weight>" +
                "<userId>4</userId>");
        bw.write("</dataFromContainer>");
        bw.write("</body></html>");
        bw.close();
    }
}
