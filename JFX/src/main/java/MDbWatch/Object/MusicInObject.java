package MDbWatch.Object;

public class MusicInObject {
	private String idOject;
	private String idMusic;
	
	public MusicInObject(String idOject, String idMusic) {
		super();
		this.idOject = idOject;
		this.idMusic = idMusic;
	}
	
	public String getIdOject() {
		return idOject;
	}
	public void setIdOject(String idOject) {
		this.idOject = idOject;
	}
	public String getIdMusic() {
		return idMusic;
	}
	public void setIdMusic(String idMusic) {
		this.idMusic = idMusic;
	}
	
	@Override
	public String toString() {
		return "MusicInObject [idOject=" + idOject + ", idMusic=" + idMusic + "]";
	}

}
