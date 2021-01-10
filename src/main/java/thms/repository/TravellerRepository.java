package thms.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import thms.model.Traveller;

@Repository
public interface TravellerRepository extends CrudRepository<Traveller, Integer>{
	
	public List<Traveller> findByUserloginUsername(String userlogin);
	public List<Traveller> findByDestination(String destination);
	public List<Traveller> findByUserloginUsernameAndDestination(String userlogin, String destination);
	public List<Traveller> findByName(String name);

	
	@Modifying
	@Query("update Traveller t set t.destination = ?2, t.enddate = ?3 where t.id = ?1")
	void update(int id, String destination, Date endDate);
	


}
