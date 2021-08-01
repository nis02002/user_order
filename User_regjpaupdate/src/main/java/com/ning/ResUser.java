package com.ning;



import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Users_demo")
public class ResUser {
	

	private Long id;
	@Size(min = 3, max = 50)
	private String name;
	
//	@NotBlank
//	@Email(message = "Please enter a valid e-mail address")
	private String email;
	
//	@NotBlank
//	@Size(min = 8, max = 15)
	private String password;
	private String phone;
	private float cost;
	
	//ArrayList<String> products;
	ArrayList<Product> products ;
	
	   
	protected ResUser() {
		this.products = new ArrayList<Product>();
	}

	protected ResUser(Long id, String name, String email, String password, String phone, float cost) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.cost = cost;

		this.products = new ArrayList<Product>();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", password=" + password + ", cost="
				+ cost + "]";
	}
	
	

	

    public void addDish(Product product)
    {
    	this.products.add(product);
    	System.out.println("added the dishes:" + product.toString());
    	this.cost = this.cost + product.getPrice();
    	System.out.println("total cost:" + cost);
    }
    
   
}
