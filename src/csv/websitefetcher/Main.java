package csv.websitefetcher;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            Fetcher fetcher = new Fetcher();
            WebsiteWriter wb = new WebsiteWriter();
            String url = "http://example.com";
            Website page = new Website(url, fetcher.getFetchedOnDate(), fetcher.getWebsiteTitle(url));
            page.setHtml(fetcher.fetchWebsite(page.getUrl()));

            page.setLinks(fetcher.getLinksFromWebsite(page.getUrl()));

            wb.saveWebsite(page);
            //output(page.getLinks().toString());

            String[] includeKeywords = {""};
            String[] excludeKeywords = {"", "", "/#"};

            // fetcher.fetchChildren(page, includeKeywords, excludeKeywords);
            /*
            for (Website w : page.getChildren()) {
                w.setHtml(fetcher.fetchWebsite(page.getUrl()));
                wb.saveWebsite(w);
            }
             */
        } catch (IOException e) {
            Main.output(e.toString());
        }
    }

    static void output(String s) {
        System.out.println(s);
    }

}
