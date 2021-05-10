package mdbwatch.model;

public class MusicRole {
    private String idMusic;
    private String idCast;
    private String role;
    public MusicRole(String idMusic, String idCast, String role) {
        super();
        this.idMusic = idMusic;
        this.idCast = idCast;
        this.role = role;
    }
    public String getIdMusic() {
        return idMusic;
    }
    public void setIdMusic(String idMusic) {
        this.idMusic = idMusic;
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
    @Override
    public String toString() {
        return "MusicRole [idMusic=" + idMusic + ", idCast=" + idCast + ", role=" + role + "]";
    }
    

}
