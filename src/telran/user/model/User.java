package telran.user.model;

public class User {
	private String email;
	private String password;

	public User(String email, String password) {
		setEmail(email);
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (validateEmail(email)) {
			this.email = email;
		} else {
			System.out.println(email + " is not valid");
		}

	}

	/*
	 * 1) @ exists and only one (done)
	 * 2) dot after @ (done)
	 * 3) after last dot minimum 2 symbols (done)
	 * 4) alphabetic, digits, _ , -, ., @ (done)
	 */
	private boolean validateEmail(String email) {
		int indexAt = email.indexOf('@');
		if (indexAt == -1 || email.indexOf('@', indexAt + 1) >= 0) {
			return false;
		}
		if (email.indexOf('.', indexAt + 1) < 0) {
			return false;
		}
		if (email.lastIndexOf('.') >= email.length() - 2) {
			return false;
		}
		for (int i = 0; i < email.length(); i++) {
			char c = email.charAt(i);
			if (!(Character.isAlphabetic(c) || Character.isDigit(c) || c == '_' || c == '-' || c == '.' || c == '@')) {
				return false;
			}
		}
		return true;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {

		if (validatePassword(password)) {
			this.password = password;
		} else {
			System.out.println(password + " is not valid");
		}
	}

	/*
	 * 1) minimum 8 symbols
	 * 2) min one symbol of uppercase
	 * 3) min one symbol of lowercase
	 * 4) min one digit
	 * 5) min one special symbol (!%@*&)
	 *
	 */
	private boolean validatePassword(String password) {
		boolean is8Symbols = false;
		boolean is1Uppercase = false;
		boolean is1Lowercase  = false;
		boolean is1Digit = false;
		boolean is1Special = false;
		String special = "!%@*&";
		if (password.length() >= 8){
			is8Symbols = true;
		}
		for (int i = 0; i < password.length(); i++) {
			char c = password.charAt(i);
			if (Character.isUpperCase(c))
				is1Uppercase = true;
			if(Character.isLowerCase(c))
				is1Lowercase = true;
			if(Character.isDigit(c))
				is1Digit = true;
			if(special.indexOf(c) != -1){
				is1Special = true;
			}

		}
		if (is8Symbols && is1Uppercase && is1Lowercase && is1Digit && is1Special)
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + "]";
	}
}
