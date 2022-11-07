package com.masai.service.iCategoryService;

import java.util.ArrayList;
import java.util.List;
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
	public Category addCategory(String categoryName, String key) throws RestaurantException {
		
		CurrentUserSession loggedInUser = sessionDao.findByUuid(key);	
		
		if(loggedInUser==null) {
			throw new RestaurantException("Please provide valid key");
			
		}
		
		Optional<Restaurant> opt = restaurantDao.findById(loggedInUser.getUserId());
		
		if(opt.isPresent()) {
			
			for(Category category : opt.get().getCategories()) {
				if(category.getCategoryName().equals(categoryName)) {
					throw new RestaurantException("Category added already");
					
				}
			}
			Category cat = new Category();
			cat.setCategoryName(categoryName);
			opt.get().getCategories().add(cat);
			cat.setRestaurants(opt.get());
			
			return categoryDao.save(cat);
			
		}
		
		throw new RestaurantException("Invalid Restaurant Details");
	}

	@Override
	public Category updateCategory(Integer catId,String catName, String key) throws RestaurantException {
		CurrentUserSession loggedInUser = sessionDao.findByUuid(key);	
		
		if(loggedInUser==null) {
			throw new RestaurantException("Please provide valid key");
			
		}
		
		Optional<Restaurant> opt = restaurantDao.findById(loggedInUser.getUserId());
		
		
		if(opt.isPresent()) {
			
			Restaurant res = opt.get();
			
			Category cat = categoryDao.findById(catId).get();
			
			if(res.getCategories().contains(cat)) {
				
				
				cat.setCategoryName(catName);
				
				return categoryDao.save(cat);
				
				
			}
			
			throw new RestaurantException("Invalid Catgory Details");

			
			
			
			
			
			
		}
		
		throw new RestaurantException("Invalid Restaurant Details");
	}

	@Override
	public String removeCategory(Integer resId,Integer catId, String key)throws RestaurantException {
		CurrentUserSession loggedInUser = sessionDao.findByUuid(key);	
		
		if(loggedInUser==null) {
			throw new RestaurantException("Please provide valid key");
			
		}
		if(loggedInUser.getUserId()==resId) {
			Restaurant res = restaurantDao.findById(resId).get();
			Category cat = categoryDao.findById(catId).get();
			if(res!=null) {
				if(cat!=null) {
					
					res.getCategories().remove(cat);
					cat.setRestaurants(null);
					
					categoryDao.delete(cat);
					return "Category Removed Successfully";

					
				}
				throw new RestaurantException("Invalid Category Details");

			}
			throw new RestaurantException("Invalid Restaurant Details");

			
			
		}
		
		throw new RestaurantException("Invalid Restaurant Details");
	}

	@Override
	public Category viewCategory(Category cat, String key)throws RestaurantException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> viewAllCategory(Integer id, String key)throws RestaurantException {
		
		CurrentUserSession loggedInUser = sessionDao.findByUuid(key);
		System.out.println(key);
		System.out.println(loggedInUser);

		if(loggedInUser==null) {
			throw new RestaurantException("Please provide valid key");
			
		}
		
		Optional<Restaurant> opt = restaurantDao.findById(id);
		
		if(opt.isPresent()) {
			
			
			List<Category> categories = categoryDao.findByRestaurants(opt.get());
			
			if(categories.size()>0) {
				return categories;
			}
			
			throw new RestaurantException("No Categories Listed");

		}
		
		throw new RestaurantException("Invalid Restaurant Details");
	}

}
