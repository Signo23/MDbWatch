package MDbWatch.Object;

public class FilmProduction {
	private String idProduction;
	private String nome;
	private String nation;
	
	public FilmProduction(String idProduction, String nome, String nation) {
		super();
		this.idProduction = idProduction;
		this.nome = nome;
		this.nation = nation;
	}
	
	public String getIdProduction() {
		return idProduction;
	}
	public void setIdProduction(String idProduction) {
		this.idProduction = idProduction;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	
	public String toString() {
		return "FilmProduction [idProduction=" + idProduction + ", nome=" + nome + ", nation=" + nation + "]";
	}
	
	

}
