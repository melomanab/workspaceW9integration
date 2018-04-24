package com.objis.formationjsf.service;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.objis.formationjsf.domaine.User;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class UserService {

	public String createUser(User user) {

		System.out.println(user.toString());
		try {
			Client client = Client.create();

			// WebResource webResource = client
			// .resource("http://localhost:8080/RESTfulExample/rest/json/metallica/post");
	
			
			WebResource webResource = client
					.resource("http://localhost:8080/JerseyMavenWebStandard/rest/json/metallica/post");
			
			
		//************************* Version 1 :  Ecriture du string ***************************************	
//			String nom = user.getNom();
//			String prenom = user.getPrenom();
//			String datedenaissance = user.getDatedenaissance();
//			String genre = user.getGenre();
//			String email = user.getEmail();
//			String niveaudeservice = user.getNiveaudeservice();
//
//			String input = "{\"nom\":\"" + nom + "\",\"prenom\":\"" + prenom + "\",\"datedenaissance\":\""
//					+ datedenaissance + "\",\"genre\":\"" + genre + "\",\"email\":\"" + email
//					+ "\",\"niveaudeservice\":\"" + niveaudeservice + "\"}";
//			
//			
//			System.out.println(input);
			
			//************************* Version 2  :   utilisation de writeValueasString ***************************************	
			ObjectMapper mapper = new ObjectMapper();
			String jsonInString = mapper.writeValueAsString(user);
			
			System.out.println("New Version : " + jsonInString);
			
			
			
			ClientResponse response = webResource.type("application/json").post(ClientResponse.class, jsonInString);
			System.out.println(response);
			if (response.getStatus() != 201) {
				System.out.println("depart du retour");
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			System.out.println("Output from Server .... \n");
			System.out.println("depart du retour");
			String reponse = response.getEntity(String.class);
			System.out.println("Le retour du WebService" + reponse);
			return reponse;

		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}

	}

}
