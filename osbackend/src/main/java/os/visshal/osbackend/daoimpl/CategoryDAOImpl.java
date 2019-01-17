package os.visshal.osbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import os.visshal.osbackend.dao.CategoryDAO;
import os.visshal.osbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	public static List<Category> categories = new ArrayList<>();
	
	static {
		
		Category category = new Category();
		
		//adding first category
		category.setId(1);
		category.setName("television");
		category.setDescription("some discription for tv");
		category.setImageURL("CAT_1.png");
		categories.add(category);
		
		//second category
		category.setId(2);
		category.setName("phone");
		category.setDescription("some discription for phone");
		category.setImageURL("CAT_2.png");
		categories.add(category);
		
		//third category
		category.setId(3);
		category.setName("laptop");
		category.setDescription("some discription for laptop");
		category.setImageURL("CAT_3.png");
		categories.add(category);
	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub 
		return categories;
	}

	@Override
	public Category get(int id) {
		
		//enhanced for loop 
		for(Category category : categories)
		{
			if(category.getId() == id) return category;
		}
		return null;
	}

}
