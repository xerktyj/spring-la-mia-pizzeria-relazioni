package it.pizzeria.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;



@Entity
@Table(name = "pizza")
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message="mettere un nome")
	@Size(min=1, max=100, message = "il nome è troppo lungo stare in 100 caratteri")
	@Column(name="nome", nullable=false)
	private String name;
	
	@NotBlank(message="mettere descrizione")
	@Size(min=1, max=255, message = "il nome è troppo lungo stare in 254 caratteri")
	@Column(name="descrizione", nullable=false)
	private String description;
	
	@NotBlank(message="mettere un link della foto")
	@Size(min=1, max=255, message = "il nome è troppo lungo stare in 254 caratteri")
	@Column(name="foto", nullable=false)
	private String photo;
	

	@Min(1)
	@Column(name="prezzo", nullable=false)
	private double price;
	
	@OneToMany(mappedBy = "pizza")
	private List<SpecialOffer> specialOffers;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) throws IllegalArgumentException {	
			this.price = price;		
	}
	
	public String toString() {
		return  "nome : " + name + " descrizione: " + description + " prezzo: " + price +"€";  
	}

}
