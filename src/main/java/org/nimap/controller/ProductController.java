package org.nimap.controller;

import org.nimap.dto.ProductDTO;
import org.nimap.entity.Category;
import org.nimap.entity.Product;
import org.nimap.service.ProductService;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {
		@Autowired
     ProductService productSer;
		
		@GetMapping
   public ResponseEntity<Page<Product>> getAllProduct(Pageable pageable){
			Page<Product> product=productSer.getAllProducts(pageable);
	   return ResponseEntity.ok(product);
   }
		@PostMapping
   public ResponseEntity<Product> createProduct(@RequestBody Product product){
	  if(product.getCategory()==null|| product.getCategory().getCategory_id()==null) {
		  throw new RuntimeException("Product having Category Id ");
	  }
	  Product createProduct = productSer.createProduct(product);
	  return ResponseEntity.ok(createProduct);
  }
		
		
		@GetMapping("/{product_id}")
		public  ResponseEntity<ProductDTO> getProductById(@PathVariable("product_id") Integer product_id){
			 Product product=productSer.getProductById(product_id);
			 ProductDTO productDTO= new ProductDTO();
			 productDTO.setProduct_id(product.getProduct_id());
			 productDTO.setProduct_name(product.getProduct_name());
			 productDTO.setProduct_price(product.getProduct_price());
			 Category category =product.getCategory();
			 
			 if(category!=null) {
				 productDTO.setCategory_id(product.getProduct_id());
				 productDTO.setCategory_name(product.getProduct_name());
			 }
			return ResponseEntity.ok(productDTO);
		}
		
		@PutMapping("/{product_id}")
		public ResponseEntity<Product> updateProductById(@PathVariable("product_id") Integer product_id,@RequestBody Product NewProduct){
			Product updateProduct=productSer.updateProductById(product_id, NewProduct);
			return ResponseEntity.ok(updateProduct);
		}
		
		@DeleteMapping("/{product_id}")
		public String deleteProductById(@PathVariable("product_id") Integer product_id){
			String deleteProduct = productSer.deleteProduct(product_id);
			if(deleteProduct!=null) {
				return"Product Detete...";
			}else {
				return"Not Detete...";
			}
			
		}
		
		
}
