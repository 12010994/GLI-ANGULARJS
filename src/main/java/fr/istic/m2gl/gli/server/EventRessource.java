package fr.istic.m2gl.gli.server;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.istic.m2gl.gli.shared.CarItf;
import fr.istic.m2gl.gli.shared.Event;
import fr.istic.m2gl.gli.shared.EventItf;
import fr.istic.m2gl.gli.shared.ParticipantItf;

@Path("/")
public class EventRessource {

	@GET
	@Path("events")
	@Produces({MediaType.APPLICATION_JSON })
	public List<Event> getEvents(){
		System.out.println("Return the events list");
		return JpaTest.eventService.getEvents();
	}
	
	@GET
	@Path("events/{id}")
	@Produces({MediaType.APPLICATION_JSON })
	public EventItf getEvent(@PathParam("id")int idEvent){
		System.out.println("Return the event selected by the id");
		return JpaTest.eventService.getEvent(idEvent);
	}
	
	@POST
	@Path("/addEvent")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addEvent(Event e){
		System.out.println("Add an event to DB");
		System.out.println(e.getPlace());
		System.out.println(e.getDate());
		JpaTest.eventService.addEvent(e);
	}
	
	@POST
	@Path("/addCar")
	public void participateWithCar(int idEvent){ //TODO nbSeat
		System.out.println("Add a participant with a car");
		JpaTest.eventService.addCar(idEvent, 4); //TODO nbSeat
	}
	
	@POST
	@Path("/joinCar")
	@Consumes(MediaType.APPLICATION_JSON)
	public void participate(int idEvent, ParticipantItf participant){
		System.out.println("Add a participant with no car");
	}
	
}
