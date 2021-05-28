package mdbwatch.model;

public class SingleProduct extends Product {
	private int year;
	private String production;
	private int idSerie;
	private int idDirector;
	private int season;
	private int number;
	
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * @return the production
	 */
	public String getProduction() {
		return production;
	}
	/**
	 * @param production the production to set
	 */
	public void setProduction(String production) {
		this.production = production;
	}
	/**
	 * @return the idSerie
	 */
	public int getIdSerie() {
		return idSerie;
	}
	/**
	 * @param idSerie the idSerie to set
	 */
	public void setIdSerie(int idSerie) {
		this.idSerie = idSerie;
	}
	/**
	 * @return the idDirector
	 */
	public int getIdDirector() {
		return idDirector;
	}
	/**
	 * @param idDirector the idDirector to set
	 */
	public void setIdDirector(int idDirector) {
		this.idDirector = idDirector;
	}
	/**
	 * @return the season
	 */
	public int getSeason() {
		return season;
	}
	/**
	 * @param season the season to set
	 */
	public void setSeason(int season) {
		this.season = season;
	}
	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	
	
	@Override
	public String toString() {
		return super.toString() + " SingleProduct [year=" + year + ", production=" + production + ", idSerie=" + idSerie + ", idDirector="
				+ idDirector + ", season=" + season + ", number=" + number + "]";
	}

	
	
}
