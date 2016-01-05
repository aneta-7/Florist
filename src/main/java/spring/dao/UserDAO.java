package spring.dao;

import java.util.List;
import spring.model.*;


public interface UserDAO {
	
	List<UserModel> getAllUsers();
	void addUser(UserModel user);
	UserModel findUserByName(String name);
	void deleteUser(UserModel user);
	void updateUser(UserModel user);
}


