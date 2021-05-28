package mdbwatch.model;

public class Music {
    
    private String idMusic;
    private String title;
    
    public Music(String idMusic, String title, String duration) {
        super();
        this.idMusic = idMusic;
        this.title = title;
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
    
    @Override
    public String toString() {
        return "Music [idMusic=" + idMusic + ", title=" + title + "]";
    }
    
    

}
