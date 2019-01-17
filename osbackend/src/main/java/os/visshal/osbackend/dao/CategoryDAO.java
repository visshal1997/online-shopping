package os.visshal.osbackend.dao;

import java.util.List;

import os.visshal.osbackend.dto.Category;

public interface CategoryDAO {

	List<Category> list();
	Category get(int id);
}
 	