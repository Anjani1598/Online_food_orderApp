package com.masai.service.iCategoryService;

import com.masai.exceptions.RestaurantException;
import com.masai.model.Category;

public interface ICategoryService {
	
	public Category addCategory(Category cat,String key)throws RestaurantException;
	
	
	public Category updateCategory(Category cat,String key);

	
	public Category removeCategory(Category cat,String key);

	
	public Category viewCategory(Category cat,String key);

	
	public Category viewAllCategory(Category cat,String key);


}
