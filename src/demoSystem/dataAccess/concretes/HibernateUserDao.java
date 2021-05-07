package demoSystem.dataAccess.concretes;

import java.util.List;

import demoSystem.dataAccess.abstracts.UserDao;
import demoSystem.entities.concretes.User;

public class HibernateUserDao implements UserDao{

	@Override
	public void add(User user) {
		System.out.println("Kullan�c� eklendi : " + user.getName());
		
	}

	@Override
	public void delete(User user) {
		System.out.println("Kullan�c� silindi : " + user.getName());
		
	}

	@Override
	public void update(User user) {
		System.out.println("Kullan�c� g�ncellendi : " + user.getName());
		
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
