package org.nimap.repository;


import org.nimap.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	Page<Category> findAll(Pageable pageable);
	

}
