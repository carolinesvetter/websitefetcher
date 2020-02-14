package csv.websitefetcher;

import java.io.File;
import java.io.IOException;

public class Main {

    static final File directory = new File("files");
    static final String url = "https://ich-tanke.de/tankstellen/super-e5/umkreis/35390-giessen/";
    static final String[] includeKeywords = {""};
    static final String[] excludeKeywords = {"", "", "/#"};

    public static void main(String[] args) {
        try {
            // create directory if it doesn't exist
            if (!directory.exists()) {
                boolean mkdir = directory.mkdir();
            }
            // Initialize objects
            Fetcher fetcher = new Fetcher();
            WebsiteWriter websiteWriter = new WebsiteWriter();
            Website website = new Website(url, fetcher.getFetchedOnDate(), fetcher.getWebsiteTitle(url));
            Parser parser = new Parser();

            // get website data
            website.setHtml(fetcher.fetchWebsite(website.getUrl()));
            website.setLinks(fetcher.getLinksFromWebsite(website.getUrl()));

            // save website html to file
            //websiteWriter.saveWebsite(website, directory);

            // get prices from website | website specific !!!
            // TODO save to database
            parser.getPrices();

            // Fetching the websites from the websites links
            // fetcher.fetchChildren(website, includeKeywords, excludeKeywords);
            // fetcher.getHTMLForChildren(website);
            // websiteWriter.saveHTMLForChildren(website);


        } catch (IOException e) {
            Main.output(e.toString());
        }
    }

    static void output(String s) {
        System.out.println(s);
    }

}
