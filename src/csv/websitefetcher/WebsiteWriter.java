package csv.websitefetcher;

import java.io.IOException;
import java.io.PrintWriter;

public class WebsiteWriter {

    public void saveWebsite(Website website) throws IOException {
        String filename = website.getFetchedOnDate() + "_" + prepareTitle(website.getTitle());
        PrintWriter outputFile = new PrintWriter("files\\" + filename + ".html");
        outputFile.append(website.getHtml().toString());
        outputFile.close();
    }

    private String prepareTitle(String pageTitle) {
        String newPageTitle = pageTitle.toLowerCase().replace("ö", "oe");
        newPageTitle = newPageTitle.replace("ä", "ae");
        newPageTitle = newPageTitle.replace("ü", "ue");
        newPageTitle = newPageTitle.replace("ß", "ss");
        newPageTitle = newPageTitle.replaceAll("[^A-Za-z0-9]", " ");
        newPageTitle = newPageTitle.replace("   ", "");
        newPageTitle = newPageTitle.replace("  ", "");
        newPageTitle = newPageTitle.replace(" ", "-");
        return newPageTitle;
    }
}
