package MDbWatch.Object;

public class Music {
	
	private String idMusic;
	private String title;
	private String duration;
	public Music(String idMusic, String title, String duration) {
		super();
		this.idMusic = idMusic;
		this.title = title;
		this.duration = duration;
	}
	
	
	public String getIdMusic() {
		return idMusic;
	}
	public void setIdMusic(String idMusic) {
		this.idMusic = idMusic;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	@Override
	public String toString() {
		return "Music [idMusic=" + idMusic + ", title=" + title + ", duration=" + duration + "]";
	}
	
	

}
