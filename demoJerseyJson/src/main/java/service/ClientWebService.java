package service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import domaine.ClientDom;
import domaine.Track;


@Path("/ws/client")
public class ClientWebService {
	
		
		@GET
		@Path("/get")
		@Produces(MediaType.APPLICATION_JSON)
		public ClientDom getClientInJSON() {

			// TO-DO
			ClientDom client = new ClientDom();
//			client.setTitle("Enter Sandman");
//			track.setSinger("Metallica");
//
			return client;

		}

		@POST
		@Path("/post")
		
		// Consumes: transforme FluxJSON --> Object Java
		@Consumes(MediaType.APPLICATION_JSON)
		public Response createClientFromJSON(ClientDom client) {

			// TODO appel create DAO !!!!!!!!!!!!!!!!!!			
			String result = "Insert OK for  : " + client;
		
			// Reponse WS
			return Response.status(201).entity(result).build();
			
		}

}
