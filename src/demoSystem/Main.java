package demoSystem;

import demoSystem.business.abstracts.UserService;
import demoSystem.business.concretes.UserManager;
import demoSystem.core.GoogleRegisterManagerAdapter;
import demoSystem.dataAccess.concretes.HibernateUserDao;
import demoSystem.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		
		UserService userService = new UserManager(new HibernateUserDao(), new GoogleRegisterManagerAdapter());
		
		User berkay = new User("berkay", "özdemir","berkay@gmail.com","beko123");
		User berkay2 = new User("beko", "beko", "berkay@gmail.com", "123456");
		User berkay3 = new User("beko", "beko", "berkay@gmail..com", "123456");
		
		userService.register(berkay);
		userService.register(berkay2);
		userService.register(berkay3);
		
		userService.login("berkay@gmail.com", "beko123");
		
		
	}

}
