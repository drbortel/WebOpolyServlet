package main;

public class TooFewDieFacesException extends Exception {

	public TooFewDieFacesException() {
		// TODO Auto-generated constructor stub
	}

	public TooFewDieFacesException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public TooFewDieFacesException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public TooFewDieFacesException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public TooFewDieFacesException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}
	
	public String getLocalizedMessage() {
		return "Error: Die instantiated with too few faces.";
	}

}
