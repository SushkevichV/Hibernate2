package services;

import java.util.List;

import dao.UserDao;
import model.User;
import model.Vehicle;

public class UserService {
	private UserDao userDao = new UserDao();
	
	public UserService() {
		
	}
	
	public User findUser(int id) {
		return userDao.findById(id);
	}
	
	public void saveUser(User user) {
		userDao.save(user);
	}
	
	public void deleteUser(User user) {
		userDao.delete(user);
	}
	
	public void updateUser(User user) {
		userDao.update(user);
	}
	
	public List<User> findAllUsers(){
		return userDao.findAll();
	}
	
	public Vehicle findVehicleById(int id) {
		return userDao.findVehicleById(id);
	}

}
