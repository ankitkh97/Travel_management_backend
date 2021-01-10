package thms.controller;

import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import thmsRabbitMQ.config.MessagingConfig;

import thms.model.Country;
import thms.model.Traveller;
import thms.model.UserLogin;
import thms.service.TravelService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TravelController {
	
	@Autowired
	TravelService travelService;
	
	
	
	@PostMapping("/login")
	@ResponseBody
	public boolean getUserValidity(@RequestBody UserLogin user)
	{
		
		 return travelService.getUserValidity(user);
		 
	}
	
	@PostMapping("/signup")
	@ResponseBody
	public boolean signup(@RequestBody UserLogin user)
	{	
		
		 String json=travelService.signup(user);
		
		 if(json==null)
		 {
			 
			 return false;	
		 }
		 
		 return true;
		 
	}
	
	
	
	@GetMapping("/username/{username}/travels")
	private List<Traveller> getUserTravels(@PathVariable("username") String username){
		return travelService.getUserAllTravels(username);
	}
	
	
	

	
	@PutMapping("/username/{username}/updateUserJourney/{id}")
	public void updateUserJourney(@RequestBody Traveller updateTravel,@PathVariable("id") int id,@PathVariable("username") String username)
	{
		
		travelService.updateTravel(updateTravel,username,id);
	}
	
	
	@GetMapping("/username/{username}/country/{destination}")
	public List<Country> getTravelsByCountry(@PathVariable("destination") String destination,@PathVariable("username") String username)
	{
		return travelService.getTravelsByCountry(username,destination);
	}
	
	

}
