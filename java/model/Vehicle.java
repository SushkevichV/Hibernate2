package model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
*/

@Entity
@Table(name = "vehicles")
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String brand;
	private String model;
	
	@ManyToOne(fetch = FetchType.LAZY)
	// многим объектам vehicle может cоответствовать один объект user
	@JoinColumn(name = "user_id") // внешний ключ
	private User user;
	
	public Vehicle() {
		
	}
	
	public Vehicle(String brand, String model) {
		this.brand = brand;
		this.model = model;
	}
	
	public int getId() {
		return id;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String model() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return brand + " " + model;
	}

}
