package bl;

import java.util.Hashtable;

public class RegistrationFormBean {

	private String emailAddress; 				/*  * Email Address */
	private String repeatEmailAddress; 			/*  * Retype Email Address */
	private String userId; 						/*  * User ID */
	private String password; 					/*  * Password */
	private String repeatPassword; 				/*  * Retype Password */
	private String firstName; 					/*  * First Name */
	private String lastName; 					/*  * Last Name */
	private String phoneNumber; 				/*  * Phone Number */
	private Hashtable<String, String> errors;

	public boolean validate() {

		boolean bool = true;

		if (emailAddress.equals("") || (emailAddress.indexOf('@') == -1)) {
			errors.put("emailAddress", "Please enter a valid email address");
			emailAddress = "";
			bool = false;
		}

		if (!emailAddress.equals("") && (repeatEmailAddress.equals("") || !emailAddress.equals(repeatEmailAddress))) {
			errors.put("repeatEmailAddress", "Please confirm your email address");
			repeatEmailAddress = "";
			bool = false;
		}

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

		if (!password.equals("") && (repeatPassword.equals("") || !password.equals(repeatPassword))) {
			errors.put("repeatPassword", "Please confirm your password");
			repeatPassword = "";
			bool = false;
		}

		if (firstName.equals("")) {
			errors.put("firstName", "Please enter your first name");
			firstName = "";
			bool = false;
		}

		if (lastName.equals("")) {
			errors.put("lastName", "Please enter your last name");
			lastName = "";
			bool = false;
		}

		if (phoneNumber.equals("")) {
			errors.put("phoneNumber", "Please enter your phone number");
			phoneNumber = "";
			bool = false;
		}

		return bool;
	}

	public String getErrorMsg(String s) {
		String errorMsg = (String) errors.get(s.trim());
		return (errorMsg == null) ? "" : errorMsg;
	}

	public RegistrationFormBean() {

		emailAddress = "";
		repeatEmailAddress = "";
		userId = "";
		password = "";
		repeatPassword = "";
		firstName = "";
		lastName = "";
		phoneNumber = "";

		errors = new Hashtable<String, String>();

	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getRepeatEmailAddress() {
		return repeatEmailAddress;
	}

	public void setRepeatEmailAddress(String repeatEmailAddress) {
		this.repeatEmailAddress = repeatEmailAddress;
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

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setErrors(String key, String msg) {
		errors.put(key, msg);
	}

}
