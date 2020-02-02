package csv.eshoptracker;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws IOException {
        Fetcher fetcher = new Fetcher();
        WebsiteWriter wb = new WebsiteWriter();
        String date = getDate();
        String link = "https://t3n.de/news/";
        //wb.saveWebsite(fetcher.getWebsiteTitle(link),"", link);
    }

    public static String getDate() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }
}
