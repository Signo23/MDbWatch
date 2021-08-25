package mdbwatch.model;
/**
 * Model a music's object
 */
public class Music {
    
    private int idMusic;
    private String title;
    
    /**
	 * @return the idMusic
	 */
	public int getIdMusic() {
		return idMusic;
	}



	/**
	 * @param idMusic the idMusic to set
	 */
	public void setIdMusic(int idMusic) {
		this.idMusic = idMusic;
	}



	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}



	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}



	@Override
    public String toString() {
        return "Music [idMusic=" + idMusic + ", title=" + title + "]";
    }
    
    

}
