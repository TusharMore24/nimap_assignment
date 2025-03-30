package org.nimap.repository;

import org.nimap.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product,Integer>{
	public Page<Product> findAll(Pageable pageable);

}
