package MDbWatch.Object;

public class StreamingService {

	private String name;
	private String webSite;


	public StreamingService(String name, String webSite) {
		this.name = name;
		this.webSite = webSite;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWebSite() {
		return webSite;
	}
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
}
