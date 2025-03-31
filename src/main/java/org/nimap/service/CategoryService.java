package org.nimap.service;

import org.nimap.entity.Category;
import org.nimap.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepo;

    public Page<Category> getAllCategory(Pageable pageable) {
        return categoryRepo.findAll(pageable);
    }

    public Category createCategory(Category category) {
        return categoryRepo.save(category);
    }
    
    public Category findCategoryById(Integer category_id) {
    	return categoryRepo.findById(category_id).orElseThrow(()->new RuntimeException("Category Not Found.."));
    }
    
    public Category UpdateCategoryById(Integer category_id ,Category newCategory) {
    	Category category=findCategoryById(category_id);
    	category.setCategory_name(newCategory.getCategory_name());
    	return categoryRepo.save(category);
    }
    
    public String deleteCategeryById(Integer categery_id) {
		categoryRepo.deleteById(categery_id);
		return "";
	}
}
