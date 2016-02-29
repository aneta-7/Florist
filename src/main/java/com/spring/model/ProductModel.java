package com.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity 
@Table(name = "Products")
@NamedQueries({
	@NamedQuery(name = "products.all", query = "Select p from ProductModel p")
})
public class ProductModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private @NonNull String name;
	private @NonNull String description;
	private @NonNull String price;
	
	@Lob
	@Column(name="foto", columnDefinition="mediumblob")
	private byte[] foto;

	public ProductModel(String name, String description, String price, byte[] foto){
		this.name = name;
		this.description = description;
		this.price = price;
		this.foto = foto;
	}

}



