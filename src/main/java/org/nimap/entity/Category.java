package org.nimap.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Id;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Category {
	
		@Id
		@GeneratedValue(strategy =GenerationType.IDENTITY)
       private Integer category_id;
       private String  category_name;
       
       @OneToMany(mappedBy="category", cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
      private List<Product> products = new ArrayList<>();

}
