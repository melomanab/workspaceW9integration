package com.mkyong.rest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mkyong.Track;
import com.mkyong.User;
import com.mkyong.dao.UserDao;


@Path("/json/metallica")
public class JSONService {
	
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Track getTrackInJSON() {

		Track track = new Track();
		track.setTitle("Bob Marley");
		track.setSinger("No Woman no cry");

		return track;

	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(User user) {
System.out.println(user.getDatedenaissance());
UserDao monUserDao = new UserDao();
boolean ResultRequete = monUserDao.createClient(user);
String result = "ok "+ ResultRequete;
System.out.println(ResultRequete);


		String resultat = "Track saved : " + user;
		System.out.println(resultat);
		return Response.status(201).entity(result).build();
		
	}

}
