package demoSystem.business.abstracts;


import demoSystem.entities.concretes.User;

public interface UserService {
	void register(User user);
	void login(String email, String password);
}