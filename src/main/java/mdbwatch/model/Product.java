package mdbwatch.model;

public abstract class Product {
	
	private int idProduct;
	private String Title;
	private String Plot;
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getPlot() {
		return Plot;
	}
	public void setPlot(String plot) {
		Plot = plot;
	}
	@Override
	public String toString() {
		return "Product [idProduct=" + idProduct + ", Title=" + Title + ", Plot=" + Plot + "]";
	}

}
