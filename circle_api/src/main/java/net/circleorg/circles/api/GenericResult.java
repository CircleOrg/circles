package net.circleorg.circles.api;

public class GenericResult {
	
	public enum ResultState {
		SUCCESS,
		ERROR
	}
	
	private ResultState state;
	private String message;
	
	public ResultState getState() {
		return state;
	}
	public void setState(ResultState state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
