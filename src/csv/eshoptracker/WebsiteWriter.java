package csv.eshoptracker;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class WebsiteWriter {
    public void saveWebsite(String pageTitle, String date, String link) throws IOException {
        String filename = date + "_" + pageTitle;
        PrintWriter outputFile = new PrintWriter("files\\" + filename + ".html");

        URL url = new URL("http://" + filename);


        URLConnection con = url.openConnection();
        InputStream is = con.getInputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String line = null;

        while ((line = br.readLine()) != null) {
            System.out.println(line);
            outputFile.println(line);
        }
        br.close();
        outputFile.close();
    }
}
