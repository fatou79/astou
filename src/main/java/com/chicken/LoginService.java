package com.chicken;

public class LoginService {
	
	public boolean validateUser(String user, String password) {
		return user.equalsIgnoreCase("fatou") && password.equals("diarra");
	}

}
