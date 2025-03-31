package org.nimap.service;

import org.nimap.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.nimap.entity.Category;
import org.nimap.entity.Product;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepo;

	public Page<Product> getAllProducts(Pageable pageable) {
		return productRepo.findAll(pageable);
	}
	
	public Product createProduct(Product product) {
		if(product.getCategory()!=null) {
			product.getCategory().getProducts().add(product);
		}
		return productRepo.save(product);
	}
	 
	public Product getProductById(Integer Product_id) {
		Product product =productRepo.findById(Product_id).orElseThrow(()-> new RuntimeException("Product Not Found "));
		Category category= product.getCategory();
		if(category==null) {
			throw new RuntimeException("incorrect category");
		}
		return product;
	}
	
	public Product updateProductById(Integer product_id,Product newProduct) {
		
		Product product = getProductById(product_id);
		product.setProduct_name(newProduct.getProduct_name());
		product.setProduct_price(newProduct.getProduct_price());
		
		return productRepo.save(product);
	}
	
	public String deleteProduct(Integer product_id) {
		productRepo.deleteById(product_id);
		return "";
	}
}
