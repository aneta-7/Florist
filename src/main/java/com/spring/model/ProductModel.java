package com.spring.model;

import java.io.ByteArrayInputStream;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "Products")
@NamedQueries({ @NamedQuery(name = "products.all", query = "Select p from ProductModel p"),
		@NamedQuery(name = "products.getByType", query = "Select p from ProductModel p where p.type = :type"),
		@NamedQuery(name = "products.getByColor", query = "Select p from ProductModel p where p.color = :color"),
		@NamedQuery(name = "products.getByName", query = "Select p from ProductModel p where p.name = :name"),
		@NamedQuery(name = "products.byId", query = "Select p from ProductModel p where p.id = :id") })
public class ProductModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private @NonNull String name;
	private @NonNull String description;
	private @NonNull String price;
	private @NonNull String type;
	private @NonNull String color;

	@Lob
	@Column(name = "foto", columnDefinition = "mediumblob")
	private byte[] foto;

	@Transient
	private StreamedContent fotoToDisplay = new DefaultStreamedContent();

	@PostLoad
	public void createFotoToDisplay() {
		if (Objects.nonNull(foto)) {
			fotoToDisplay = new DefaultStreamedContent(new ByteArrayInputStream(foto), "image/png");
		}
	}

	public ProductModel(String name, String description, String price, String type, String color, byte[] foto) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.type = type;
		this.color = color;
		this.foto = foto;
	}

}
