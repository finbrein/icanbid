package bl;

import java.util.Hashtable;

public class LoginFormBean {

	String userId = "";		/*  * User ID */
	String password = "";	/*  * Password */
	private Hashtable<String, String> errors;
	
	public boolean validate() {
		
		boolean bool = true;
		
		if (userId.equals("") || userId.length() < 9) {
			errors.put("userId", "Please enter a valid username");
			userId = "";
			bool = false;
		}
		
		if (password.equals("") || password.length() < 8) {
			errors.put("password", "Please enter a valid password");
			password = "";
			bool = false;
		}
		
		return bool;
	}
	
	public String getErrorMsg(String s) {
		String errorMsg = (String) errors.get(s.trim());
		return (errorMsg == null) ? "" : errorMsg;
	}
	
	public LoginFormBean() {

		userId = "";
		password = "";

		errors = new Hashtable<String, String>();

	}
	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setErrors(String key, String msg) {
		errors.put(key, msg);
	}
}
