package csv.websitefetcher;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

public class Fetcher {

    public StringBuilder fetchWebsite(String link) throws IOException {
        URL url = new URL(link);
        BufferedReader r = new BufferedReader(new InputStreamReader(url.openStream()));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = r.readLine()) != null)
            stringBuilder.append(line + "\n");
        return stringBuilder;
    }

    public List<String> getLinksFromWebsite(String link) throws IOException {
        Document doc = Jsoup.connect(link).get();
        return doc.select("a[href]").eachAttr("abs:href");
    }

    public String getWebsiteTitle(String link) throws IOException {
        Document doc = Jsoup.connect(link).get();
        return doc.title();
    }
}
