package demoSystem.googleRegister;

import demoSystem.entities.concretes.User;

public class GoogleRegisterManager {
	public void register(User user) {
		System.out.println("Google ile kayýt yapýldý : " + user.getName());
	}
}
