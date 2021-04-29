package MDbWatch.Object;

public class FilmRole {
	private String idFilm;
	private String idCast;
	private String role;

	
	public FilmRole(String idFilm, String idCast, String role) {
		super();
		this.idFilm = idFilm;
		this.idCast = idCast;
		this.role = role;
	}
	
	public String getIdFilm() {
		return idFilm;
	}
	public void setIdFilm(String idFilm) {
		this.idFilm = idFilm;
	}
	public String getIdCast() {
		return idCast;
	}
	public void setIdCast(String idCast) {
		this.idCast = idCast;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
