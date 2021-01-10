package thms.service;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thms.model.Country;
import thms.model.Traveller;
import thms.model.UserLogin;
import thms.repository.TravellerRepository;
import thms.repository.UserRepository;

@Service
@Transactional
public class TravelService  {
	
	@Autowired
	TravellerRepository travellerRepository;
	
	@Autowired
	UserRepository userRepository;
	

	public String signup(UserLogin user) {
		if(userRepository.findByUsername(user.getUsername())==null)
		{
			userRepository.save(user);
			
			return "Signup successful!!";
		}
		else
		{
			System.out.println("NUll");
			return null;
		}
		
	}
	
	public boolean getUserValidity(UserLogin user) {
		if(userRepository.findByUsername(user.getUsername())==null)
			return false;
		String x=userRepository.findByUsername(user.getUsername()).getUsername();
		String y=userRepository.findByUsername(user.getUsername()).getPassword();
		String z=user.getUsername();
		String w=user.getPassword();
		
		if(x!=null && x.equals(z) && y!=null && y.equals(w))
		{
			return true;
		}
		else
		{
		return false;
		}
	}
	
	public List<Traveller> getUserAllTravels(String name) {
		List<Traveller> list=new ArrayList<>();

		travellerRepository.findByUserloginUsername(name).forEach(list::add);
		
		return list;
	}
	
	
	public void addUserJourney(Traveller newTravel) {

		travellerRepository.save(newTravel);
	}
	
	public void updateTravel(Traveller updateTravel,String username,int id) {
		updateTravel.setUserlogin(new UserLogin(username,""));
		
		
		String destination=updateTravel.getDestination();
		Date endDate=updateTravel.getEnddate();
		
		travellerRepository.update(id, destination, endDate);
		
		}
	
	public List<Country> getTravelsByCountry(String userlogin, String destination) {
		List<Country> list = new ArrayList<Country>();
		travellerRepository.findByUserloginUsernameAndDestination(userlogin,destination).forEach(x->{
			list.add(new Country(x.getStartdate(), x.getEnddate(), (int)((x.getEnddate().getTime() - x.getStartdate().getTime()) / (1000 * 60 * 60 * 24))));
			
		});
		
		return list;
	}
	
	

}
