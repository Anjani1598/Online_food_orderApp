package com.masai.service.keyservice;

import com.masai.exceptions.RestaurantException;
import com.masai.model.CurrentUserSession;

public interface KeyService {
	
	
	public CurrentUserSession getLoggedInuserKey(String mobileNumber)throws RestaurantException;
	public CurrentUserSession getLoggedInadminKey(String mobileNumber)throws RestaurantException;

}
