package csv.websitefetcher;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
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

    public List<Website> fetchChildren(Website website, String keyword, String excludedKeyword) throws IOException {
        List<String> links = filter(website.getLinks(), keyword, excludedKeyword, website);
        List<Website> websites = new ArrayList<>();
        for (String s : links) {
            websites.add(new Website(s, getWebsiteTitle(s)));
        }
        website.setChildren(websites);
        return websites;
    }

    public List<String> filter(List<String> links, String keyword, String excludedKeyword, Website website) {
        List<String> filteredList = new ArrayList<>();
        for (String s : links) {
            String sLowerCase = s.toLowerCase();
            if (!sLowerCase.equals(website.getUrl().toLowerCase()) &&
                    sLowerCase.contains(keyword.toLowerCase()) &&
                    sLowerCase.startsWith(website.getUrl()) &&
                    !sLowerCase.contains(excludedKeyword.toLowerCase())
            ) {
                filteredList.add(s);
            }
        }
        Main.output(filteredList.toString());
        return filteredList;
    }
}
