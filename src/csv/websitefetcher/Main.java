package csv.websitefetcher;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Fetcher fetcher = new Fetcher();
        WebsiteWriter wb = new WebsiteWriter();
        String url = "https://www.bild.de/news/newsticker/news/alle-news-54190480.bild.html";
        Website page = new Website(url, fetcher.getFetchedOnDate(), fetcher.getWebsiteTitle(url));
        page.setHtml(fetcher.fetchWebsite(page.getUrl()));
        page.setLinks(fetcher.getLinksFromWebsite(page.getUrl()));

        String[] includeKeywords = {};
        String[] excludeKeywords = {};

        fetcher.fetchChildren(page, includeKeywords, excludeKeywords);
        for (Website w : page.getChildren()) {
            w.setHtml(fetcher.fetchWebsite(page.getUrl()));
            wb.saveWebsite(w);
        }
    }

    static void output(String s) {
        System.out.println(s);
    }

}
