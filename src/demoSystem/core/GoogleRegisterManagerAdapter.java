package demoSystem.core;

import demoSystem.entities.concretes.User;
import demoSystem.googleRegister.GoogleRegisterManager;

public class GoogleRegisterManagerAdapter implements GoogleService {

	@Override
	public void registerToDb(User user) {
		GoogleRegisterManager googleManager = new GoogleRegisterManager();
		googleManager.register(user);
		
	}

}
