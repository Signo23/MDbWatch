package mdbwatch.model;

public class ValutationObj {
    private String idOggetto;
    private String titolo;
    private String trama;
    private int anno;
    private String regista;
    private String produzione;
    
    public ValutationObj(String id, String titolo, String trama, int anno, String idRegista, String idProduzione) {
        this.idOggetto = id;
        this.titolo = titolo;
        this.trama = trama;
        this.anno = anno;
        this.regista = idRegista;
    }
    
    public String getIdOggetto() {
        return this.idOggetto;
    }
    public void setIdOggetto(String idOggetto) {
        this.idOggetto = idOggetto;
    }
    public String getTitolo() {
        return this.titolo;
    }
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    public String getTrama() {
        return this.trama;
    }
    public void setTrama(String trama) {
        this.trama = trama;
    }
    public int getAnno() {
        return this.anno;
    }
    public void setAnno(int anno) {
        this.anno = anno;
    }
    public String getRegista() {
        return this.regista;
    }
    public void setRegista(String regista) {
        this.regista = regista;
    }

    public String getProduzione() {
        return produzione;
    }

    public void setProduzione(String produzione) {
        this.produzione = produzione;
    }

    @Override
    public String toString() {
        return "OggettoValutazione [idOggetto=" + idOggetto + ", titolo=" + titolo + ", trama=" + trama + ", anno="
                + anno + ", regista=" + regista + ", produzione=" + produzione + "]";
    }
    

}
