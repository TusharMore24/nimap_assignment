package org.nimap.controller;


import org.nimap.entity.Category;
import org.nimap.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    
	@Autowired
	CategoryService categorySer;
	
	@GetMapping
	public ResponseEntity<Page<Category>> getAllCategory(Pageable pageable) {

		Page<Category> categories = categorySer.getAllCategory(pageable);
		return ResponseEntity.ok(categories);
	}

    @PostMapping 
    public ResponseEntity<Category> createNewCategory(@RequestBody Category category){
    	Category addCategory=categorySer.createCategory(category);
    	return ResponseEntity.ok(addCategory);
    }
	
    @GetMapping("/{category_id}")
    public ResponseEntity<Category> findCategoryById(@PathVariable("category_id") Integer category_id ){
    	Category category=categorySer.findCategoryById(category_id);
    	return ResponseEntity.ok(category);
    }
    
    @PutMapping("/{category_id}")
    public ResponseEntity<Category> updateCategoryById(@PathVariable("category_id") Integer category_id,@RequestBody Category newCategory){
    	Category updateCategory=categorySer.UpdateCategoryById(category_id,newCategory);
    	return ResponseEntity.ok(updateCategory);
    }
    
    @DeleteMapping("{category_id}")
	public String deleteCategoryById(@PathVariable("category_id") Integer category_id) {

		String deleteCategeryById = categorySer.deleteCategeryById(category_id);
		if(deleteCategeryById!=null) {
			return"Categoey Is Delete...";
		}else {
			return"Not Delete...";
		}
	}
}
