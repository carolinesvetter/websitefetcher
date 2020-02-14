package csv.websitefetcher;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class Parser {

    void getPrices() throws IOException {
        File input = new File("files/2020-02-07-12-16-32_benzinpreise-super-in-35390-giessen-und-umkreistanken-sie-bei-der-guenstigsten-tankstelle-.html");
        Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");

        Element content = doc.getElementById("search-result");
        Elements elements = content.getElementsByTag("li");
        for (Element element : elements) {
            String preis = element.getElementsByClass("preis1").text();
            String tankstelle = element.getElementsByClass("tankstelle").text();
            Main.output(preis + " " + tankstelle);
            //String linkText = element.text();
            //Main.output(linkText);
        }
    }
}
