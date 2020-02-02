package csv.eshoptracker;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class Fetcher {

    public StringBuilder fetchWebsite(String link) throws IOException {
        URL url = new URL(link);
        BufferedReader r = new BufferedReader(new InputStreamReader(url.openStream()));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = r.readLine()) != null)
            stringBuilder.append(line);
        return stringBuilder;
    }

    public ArrayList<String> getLinksFromWebsite(String link) throws IOException {
        File input = new File("/tmp/input.html");
        Document doc = Jsoup.parse(new File(""), "UTF-8", "http://example.com/");
        Elements links = doc.select("a[href]"); // a with href
        Elements pngs = doc.select("img[src$=.png]");
// img with src ending .png

        Element masthead = doc.select("div.masthead").first();
        return new ArrayList<>();
    }

    public String getWebsiteTitle(String link) throws IOException {
        Document doc = Jsoup.connect("http://google.com").get();
        return doc.title();
    }
}
