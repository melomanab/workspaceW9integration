package com.objis.formationjsf.service;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.objis.formationjsf.domaine.User;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class UserService {
	
	ObjectMapper mapper = new ObjectMapper();

	public String createUser(User user) {
//		boolean res = false;
		String output ="";
		try {
			Client client = Client.create();
			
			String jsonInString = mapper.writeValueAsString(user);
			System.out.println("Coté client... jsf...");
			System.out.println(jsonInString);
			
			WebResource webResource = client.resource("http://localhost:8080/webServiceJsfTest/webapi/myresource/");
			
			ClientResponse response = webResource.type("application/json")
					   .post(ClientResponse.class, jsonInString);
			
			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "
				     + response.getStatus());
			}
			
			output = response.getEntity(String.class);
			System.out.println("output...");
			System.out.println(output);
			boolean res = mapper.readValue(output, Boolean.class);
			System.out.println(res);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
//		System.out.println("les res = "+ res);
		return output;
	}

}
