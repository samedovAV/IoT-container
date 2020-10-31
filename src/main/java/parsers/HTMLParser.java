package parsers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HTMLParser {

    public static void main(String[] args) throws IOException {
        parseHTML();
    }

    public static void parseHTML() throws IOException {
        File input = new File("dataFromContainer.html");

        FileWriter output = new FileWriter("dataFromContainer(HTML).txt");

        Document htmlFile = Jsoup.parse(input, "UTF-8");
        output.write(htmlFile.getAllElements().get(0).toString());
        output.flush();
    }
}
