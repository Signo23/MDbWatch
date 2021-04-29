package MDbWatch.Object;

public class Reference {
	
	private String idFrom;
	private String idTo;
	private String type;
	
	public Reference(String idFrom, String idTo, String type) {
		this.idFrom = idFrom;
		this.idTo = idTo;
		this.type = type;
	}
	
	public String getIdFrom() {
		return idFrom;
	}
	public void setIdFrom(String idFrom) {
		this.idFrom = idFrom;
	}
	public String getIdTo() {
		return idTo;
	}
	public void setIdTo(String idTo) {
		this.idTo = idTo;
	}
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Reference [idFrom=" + idFrom + ", idTo=" + idTo + ", type=" + type + "]";
	}
	
}
