package service;

import org.codehaus.jackson.map.ObjectMapper;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import domaine.ClientDom;

//import gtm.formation.demoJerseyClient.domaine.Client;


public class ClientJerseyPostClient {


		try {

			// ==== Client consommateur de WebService demoJerseyJson =====		
			// --- Client Jersey
			Client clientJ = Client.create();

			// --- Preparation requete URL verbe:POST
			// A. sur serveur local: OK
			WebResource webResource = clientJ
					.resource("http://localhost:8080/demoJerseyJson/webapi/ws/client/post");

			// B. sur serveur distant: OK
			// WebResource webResource =
			// client.resource("http://192.168.1.55:8080/tpJson/rest/json/metallica/post");

			// Input (required in POST)
			String input;
			
			// A. Flux JSON EN DUR: OK
			// input = "{\"nom\":\"Moreno\",\"prenom\":\"Beatriz\"}";
			
			// B. NEW: Generer flux Json a parti d'un objet
			// Jackon? YES
			ObjectMapper mapper = new ObjectMapper();
			ClientDom client = new ClientDom(1, "userNom", "userPrenom", 30, 1);
			
			//Conversion Object to JSON in String
			String jsonStringFromObject = mapper.writeValueAsString(client);
			input = jsonStringFromObject;
					
			// B. Flux JSON a partir d'un objet Java
			// Simule entrée formulaire
			// Track inputTrack = new Track("");

			// --- Requete/Response
			// Requête de type POST (reçois input)
			ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);

			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			// Recuperation données
			System.out.println("Output from Server .... \n");
			String output = response.getEntity(String.class);
			System.out.println(output);

			// Recuperation d'autres detail de la reponse
			String langue = response.getLanguage();
			int length = response.getLength();
			System.out.println("Langue:" + langue);
			System.out.println("Length:" + length);

		} catch (Exception e) {

			e.printStackTrace();

		}


}
