package link.rezimaulana.livecodspring.constant;

public enum ResponseConst {

	CREATED("Created"), UPDATED("Updated"), DELETED("Deleted"), FAILED("Failed");
	
	private final String response;
	
	ResponseConst(final String response) {
		this.response = response;
	}
	
	public String getResponse() {
		return response;
	}
	
}
