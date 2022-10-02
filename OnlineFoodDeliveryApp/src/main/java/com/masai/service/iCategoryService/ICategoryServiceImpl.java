package com.masai.service.iCategoryService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.CustomerException;
import com.masai.exceptions.RestaurantException;
import com.masai.model.Category;
import com.masai.model.CurrentUserSession;
import com.masai.model.Restaurant;
import com.masai.repositories.CategoryDao;
import com.masai.repositories.RestaurantDao;
import com.masai.repositories.SessionDao;

@Service
public class ICategoryServiceImpl implements ICategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private RestaurantDao restaurantDao;
	
	@Autowired
	private SessionDao sessionDao;
	
	
	
	@Override
	public Category addCategory(Category cat, String key) throws RestaurantException {
		
		CurrentUserSession loggedInUser = sessionDao.findByUuid(key);	
		
		if(loggedInUser==null) {
			throw new RestaurantException("Please provide valid key");
			
		}
<<<<<<< HEAD
		return null;
=======
		
		Optional<Restaurant> opt = restaurantDao.findById(loggedInUser.getUserId());
		
		if(opt.isPresent()) {
			
			opt.get().getCategories().add(cat);
			cat.getRestaurants().add(opt.get());
			
			return categoryDao.save(cat);
			
		}
		
		throw new RestaurantException("Invalid Restaurant Details");
>>>>>>> 2fbf0e1b7b0688dd6c5e03958796d9bad6fb965d
	}

	@Override
	public Category updateCategory(Category cat, String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category removeCategory(Category cat, String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category viewCategory(Category cat, String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category viewAllCategory(Category cat, String key) {
		// TODO Auto-generated method stub
		return null;
	}

}
