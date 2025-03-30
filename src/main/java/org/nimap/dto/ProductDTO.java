package org.nimap.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
	private Integer product_id;
	private String product_name;
	private Double product_price;
	
	private Integer category_id;
	private String category_name;
}
