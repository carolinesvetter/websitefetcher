package csv.websitefetcher;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    public void fetchChildren(Website website, String[] includeKeywords, String[] excludedKeywords) throws IOException {
        List<String> links = filter(website.getLinks(), includeKeywords, excludedKeywords, website);
        List<Website> websites = new ArrayList<>();
        for (String s : links) {
            websites.add(new Website(s, getFetchedOnDate(), getWebsiteTitle(s)));
        }
        website.setChildren(websites);
    }

    public List<String> filter(List<String> links, String[] includeKeywords, String[] excludeKeywords, Website website) {
        List<String> filteredList = new ArrayList<>();
        for (String s : links) {
            String sLowerCase = s.toLowerCase();
            if (containsKeywords(sLowerCase, includeKeywords)
                    && !containsKeywords(sLowerCase, excludeKeywords)
            ) {
                filteredList.add(s);
            }
        }
        return filteredList;
    }

    private boolean containsKeywords(String sLowerCase, String[] keywords) {
        for (String s : keywords) {
            if (sLowerCase.contains(s)) {
                return true;
            }
        }
        return false;
    }

    public String getFetchedOnDate() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        return dateFormat.format(date);
    }
}
