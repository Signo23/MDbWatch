package MDbWatch.Object;

public class Cast {
	private String idCastGenerated;
	private String name;
	private String surname;
	private String birth;
	private String birthPlace;
	
	public Cast(String iD, String name, String surname, int bDay, int bMonth, int bYear, String bPlace){
		this.idCastGenerated = iD;
		this.name = name;
		this.surname = surname;
		this.birthPlace = bPlace;
		this.birth = bDay + "/" + bMonth +"/" + bYear;

	}
	
	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getIdCastGenerated() {
		return idCastGenerated;
	}
	public void setIdCastGenerated(String iD) {
		this.idCastGenerated = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getBirthPlace() {
		return birthPlace;
	}
	public void setBirthPlace(String bPlace) {
		this.birthPlace = bPlace;
	}

	@Override
	public String toString() {
		return "Cast [idCastGenerated=" + idCastGenerated + ", name=" + name + ", surname=" + surname + ", birth="
				+ birth + ", birthPlace=" + birthPlace + "]";
	}
	
}
