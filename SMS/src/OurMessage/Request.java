package OurMessage;

import java.io.Serializable;

public class Request implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Object Request;
	private int Rtype;
	public static int insert = 1;
	public static int select = 2; 
	public static int display= 3;
	public static int update = 4;
	public static int getuser = 5;//login checking user
	public Request(Object request,int rtype){
		setRequest(request);
		setRtype(rtype);
	}
	public Object getRequest() {
		return Request;
	}
	public void setRequest(Object request) {
		Request = request;
	}
	public int getRtype() {
		return Rtype;
	}
	public void setRtype(int rtype) {
		Rtype = rtype;
	}
}
