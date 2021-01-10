package thms.repository;

import org.springframework.data.repository.CrudRepository;

import thms.model.UserLogin;

public interface UserRepository extends CrudRepository<UserLogin,String>{
	
	public UserLogin findByUsername(String username);

}