package mdbwatch.model;

public class Production {
    private String idProduction;
    private String name;
    private String nation;
    
    public Production(String idProduction, String name, String nation) {
        super();
        this.idProduction = idProduction;
        this.name = name;
        this.nation = nation;
    }
    
    public String getIdProduction() {
        return idProduction;
    }
    public void setIdProduction(String idProduction) {
        this.idProduction = idProduction;
    }
    public String getName() {
        return name;
    }
    public void setName(String nome) {
        this.name = nome;
    }
    public String getNation() {
        return nation;
    }
    public void setNation(String nation) {
        this.nation = nation;
    }
    
    public String toString() {
        return "FilmProduction [idProduction=" + idProduction + ", nome=" + name + ", nation=" + nation + "]";
    }
    
    

}
