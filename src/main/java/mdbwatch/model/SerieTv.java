package mdbwatch.model;

public class SerieTv implements Product {

	private int idProduct;
	private String Title;
	private String Plot;
	
	
	
	/**
	 * @return the idProduct
	 */
	public int getIdProduct() {
		return idProduct;
	}



	/**
	 * @param idProduct the idProduct to set
	 */
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}



	/**
	 * @return the title
	 */
	public String getTitle() {
		return Title;
	}



	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		Title = title;
	}



	/**
	 * @return the plot
	 */
	public String getPlot() {
		return Plot;
	}



	/**
	 * @param plot the plot to set
	 */
	public void setPlot(String plot) {
		Plot = plot;
	}



	@Override
	public String toString() {
		return "SerieTv [idProduct=" + idProduct + ", Title=" + Title + ", Plot=" + Plot + "]";
	}
	
	
}
