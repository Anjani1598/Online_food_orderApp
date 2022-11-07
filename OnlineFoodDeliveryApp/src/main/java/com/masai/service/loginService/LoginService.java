package com.masai.service.loginService;

import com.masai.exceptions.LoginException;
import com.masai.model.CurrentUserSession;
import com.masai.model.LoginDTO;

public interface LoginService {
	
	public CurrentUserSession logIntoAccount(LoginDTO dto)throws LoginException;

	public String logOutFromAccount(String key)throws LoginException;

}
