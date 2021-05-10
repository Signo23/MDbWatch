package mdbwatch.model;

public class StreamingService {

    private String name;
    private String webSite;


    public StreamingService(final String name, final String webSite) {
            this.name = name;
            this.webSite = webSite;
    }

    public final String getName() {
            return name;
    }
    public final void setName(final String name) {
            this.name = name;
    }
    public final String getWebSite() {
            return webSite;
    }
    public final void setWebSite(final String webSite) {
            this.webSite = webSite;
    }
}
