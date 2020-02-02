package csv.websitefetcher;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws IOException {
        Fetcher fetcher = new Fetcher();
        WebsiteWriter wb = new WebsiteWriter();
        String url = "https://t3n.de/news/";
        Website page = new Website(url, getDate(), fetcher.getWebsiteTitle(url));
        page.setHtml(fetcher.fetchWebsite(page.getUrl()));
        page.setLinks(fetcher.getLinksFromWebsite(page.getUrl()));
        fetcher.fetchChildren(page, "https://t3n.de/news/", "/page/");
//        for (Website w:
//             page.getChildren()) {
//            output(w.getTitle());
//        }
        //wb.saveWebsite(page);
    }

    static void output(String s) {
        System.out.println(s);
    }

    public static String getDate() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        return dateFormat.format(date);
    }
}
