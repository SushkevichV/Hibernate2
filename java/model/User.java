package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.ArrayList;

/*import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
*/

@Entity
@Table (name = "users")
public class User {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int age;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	// одному объекту класса User может соответствовать несколько объектов vehicle
	// mappedBY указывает на поле класса User
	// orphanRemoval при удалении объекта из таблицы users удалит связанные с ним объекты из таблицы vehicles
	private List<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	public User() {
		
	}
	
	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void addVehicle(Vehicle vehicle) {
		vehicle.setUser(this);
		vehicles.add(vehicle);
	}
	
	public void remaveVehicle(Vehicle vehicle) {
		vehicles.remove(vehicle);
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public List<Vehicle> getVehicles(){
		return vehicles;
	}
	
	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
	@Override
	public String toString() {
		return "models.User{" + "id" + id + ", name=" + name + ", age=" + age + "}";
	}

}
