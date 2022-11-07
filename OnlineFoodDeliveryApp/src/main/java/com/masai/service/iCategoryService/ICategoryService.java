package com.masai.service.iCategoryService;

import java.util.List;

import com.masai.exceptions.RestaurantException;
import com.masai.model.Category;

public interface ICategoryService {
	
	public Category addCategory(String categoryName,String key)throws RestaurantException;
	
	
	public Category updateCategory(Integer catId, String catName, String key)throws RestaurantException;

	
	public String removeCategory(Integer resId,Integer catId,String key)throws RestaurantException;

	
	public Category viewCategory(Category cat,String key)throws RestaurantException;

	
	public List<Category> viewAllCategory(Integer id,String key)throws RestaurantException;


}
