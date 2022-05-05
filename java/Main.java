import java.sql.SQLException;
import java.util.List;

import model.User;
import model.Vehicle;
import services.UserService;

/* Работает с двумя связанными между собой таблицами. Основная таблица users, к ней подключена таблица vehicles
 * Зависимость определена следующим образом: в таблице vehicle колонка user_id использует в качестве внешнего ключа (Foreign Key) колонку id таблицы users
 * Также указаны действия (Action): On update - CASCADE, On delete - CASCADE. Изменений записей в таблице users влечет именения в таблице vehicle
 */
public class Main {

	public static void main(String[] args) throws SQLException {
		UserService userService = new UserService();
		User user = new User("Tim", 26);
		
		userService.saveUser(user);
		Vehicle ford = new Vehicle("VW", "Polo");
		ford.setUser(user);
		user.addVehicle(ford);
		Vehicle audi = new Vehicle("Audi", "A6");
		audi.setUser(user);
		user.addVehicle(audi);
		userService.updateUser(user);
		user.setName("Tom");
		userService.updateUser(user);
		
		user = userService.findUser(32);
		if (user != null) {
			userService.deleteUser(user);
		}
		
		List<User> users = userService.findAllUsers();
		users.stream().forEach(x -> System.out.println(x.toString()));

	}

}
