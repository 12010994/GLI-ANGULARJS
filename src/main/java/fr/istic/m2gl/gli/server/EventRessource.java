package fr.istic.m2gl.gli.server;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.istic.m2gl.gli.shared.Event;
import fr.istic.m2gl.gli.shared.EventItf;
import fr.istic.m2gl.gli.shared.ParticipantItf;

@Path("/")
public class EventRessource {

	@GET
	@Path("events")
	@Produces({MediaType.APPLICATION_JSON })
	public List<Event> getEvents(){
		System.out.println("Returns the events list");
		return JpaTest.eventService.getEvents();
	}
	
	@GET
	@Path("events/{id}")
	@Produces({MediaType.APPLICATION_JSON })
	public EventItf getEvent(@PathParam("id")int idEvent){
		return JpaTest.eventService.getEvent(idEvent);
	}
	
	@POST
	@Path("/addEvents")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addEvent(Event e){
		JpaTest.eventService.addEvent(e);
	}
	
	@POST
	@Path("/todo1")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public void participateWithCar(int idEvent, ParticipantItf participant){
		System.out.println("Adds a participant with a car");
	}
	
	@POST
	@Path("/todo2")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public void participate(int idEvent, ParticipantItf participant){
		System.out.println("Adds a participant with no car");
	}

}
