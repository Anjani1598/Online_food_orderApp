package com.masai.service.iCategoryService;

import com.masai.exceptions.RestaurantException;
import com.masai.model.Category;

public interface ICategoryService {
	
<<<<<<< HEAD
	public Category addCategory(Category cat,String key) throws RestaurantException;
=======
	public Category addCategory(Category cat,String key)throws RestaurantException;
>>>>>>> 2fbf0e1b7b0688dd6c5e03958796d9bad6fb965d
	
	
	public Category updateCategory(Category cat,String key);

	
	public Category removeCategory(Category cat,String key);

	
	public Category viewCategory(Category cat,String key);

	
	public Category viewAllCategory(Category cat,String key);


}
