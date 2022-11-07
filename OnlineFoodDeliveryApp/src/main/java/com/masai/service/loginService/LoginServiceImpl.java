package com.masai.service.loginService;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.masai.exceptions.LoginException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.model.LoginDTO;
import com.masai.model.Restaurant;
import com.masai.model.RestaurantAdmin;
import com.masai.repositories.AdminDao;
import com.masai.repositories.CustomerDao;
import com.masai.repositories.RestaurantDao;
import com.masai.repositories.SessionDao;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private CustomerDao cDao;
	
	@Autowired
	private SessionDao sDao;
	
	@Autowired
	private RestaurantDao aDao;
	
	
	
	@Override
	public CurrentUserSession logIntoAccount(LoginDTO dto)throws LoginException{
		System.out.println(dto.getRole()=="admin");
		
		if(dto.getRole().equals("admin")) {
			Restaurant existingCustomer = aDao.findByMobileNumber(dto.getMobileNumber());
			System.out.println(existingCustomer);
			if(existingCustomer == null) {
				
				throw new LoginException("Please Enter a valid mobile number");
				
				 
			}
			
			
			
			
			Optional<CurrentUserSession> validCustomerSessionOpt =  sDao.findById(existingCustomer.getRestaurantId());
			
			
			
			
			
			if(validCustomerSessionOpt.isPresent()) {
				
				throw new LoginException("User already Logged In with this number");
				
			}
			
			if(existingCustomer.getPassword().equals(dto.getPassword())) {
				
				String key= RandomString.make(6);
				
				
				
				CurrentUserSession currentUserSession = new CurrentUserSession(existingCustomer.getRestaurantId(),key,LocalDateTime.now());
				
				sDao.save(currentUserSession);

				return currentUserSession;
			}
			else
				throw new LoginException("Please Enter a valid password");
			
			
		}else {
			
			Customer existingCustomer= cDao.findByMobileNumber(dto.getMobileNumber());
			System.out.println(dto);
			System.out.println(existingCustomer);
			if(existingCustomer == null) {
				
				throw new LoginException("Please Enter a valid mobile number");
				
				 
			}
			
			
			
			
			Optional<CurrentUserSession> validCustomerSessionOpt =  sDao.findById(existingCustomer.getCustomerId());
			
			
			if(validCustomerSessionOpt.isPresent()) {
				
				throw new LoginException("User already Logged In with this number");
				
			}
			
			if(existingCustomer.getPassword().equals(dto.getPassword())) {
				
				String key= RandomString.make(6);
			
				CurrentUserSession currentUserSession = new CurrentUserSession(existingCustomer.getCustomerId(),key,LocalDateTime.now());
				
				sDao.save(currentUserSession);

				return currentUserSession;
			}
			else
				throw new LoginException("Please Enter a valid password");

		}
		
				
		
	}


	@Override
	public String logOutFromAccount(String key)throws LoginException {
		
		CurrentUserSession validCustomerSession = sDao.findByUuid(key);
		
		
		if(validCustomerSession == null) {
			throw new LoginException("User Not Logged In with this number");
			
		}
		
		
		sDao.delete(validCustomerSession);
		
		
		return "Logged Out !";
		
		
	}

}
