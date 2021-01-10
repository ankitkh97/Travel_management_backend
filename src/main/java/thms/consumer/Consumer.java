package thms.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import thms.config.MessagingConfig;
import thms.model.Traveller;

import thms.service.TravelService;

@Component
public class Consumer {
	@Autowired
	TravelService travelService;
	
	@RabbitListener(queues = MessagingConfig.QUEUE)
	public void addUserJourney(Traveller newTravel) {
		
		travelService.addUserJourney(newTravel);		
		
	}

}
