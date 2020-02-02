package csv.websitefetcher;

import java.util.List;

public class Website {

    private String title;
    private String url;
    private List<String> links;
    private String fetchedOnDate;
    private StringBuilder html;
    private List<Website> children;

    Website(String url, String fetchedOnDate, String title) {
        this.url = url;
        this.fetchedOnDate = fetchedOnDate;
        this.title = title;
    }

    Website(String url, String fetchedOnDate) {
        this.url = url;
        this.fetchedOnDate = fetchedOnDate;
    }

    Website(String url) {
        this.url = url;
    }

    Website() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getLinks() {
        return links;
    }

    public void setLinks(List<String> links) {
        this.links = links;
    }

    public String getFetchedOnDate() {
        return fetchedOnDate;
    }

    public void setFetchedOnDate(String fetchedOnDate) {
        this.fetchedOnDate = fetchedOnDate;
    }

    public StringBuilder getHtml() {
        return html;
    }

    public void setHtml(StringBuilder html) {
        this.html = html;
    }

    public List<Website> getChildren() {
        return children;
    }

    public void setChildren(List<Website> websites) {
        this.children = websites;
    }
}
