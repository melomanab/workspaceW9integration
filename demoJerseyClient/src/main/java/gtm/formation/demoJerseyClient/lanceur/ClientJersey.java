package gtm.formation.demoJerseyClient.lanceur;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ClientJersey {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			
			// --- Client Java
			Client client = Client.create();
		
			// --- Preparation requete URL verbe:GET			
/*			
			// A. sur serveur local: OK
			 Utilisation WebService JSONService du projet demoJerseyJson
			 WebResource webResource = client.resource("http://localhost:8080/demoJerseyJson/webapi/json/metallica/get");
*/
			// B. sur serveur distant: OK
			WebResource webResource = client
			   .resource("http://192.168.1.55:8080/tpJson/rest/json/metallica/get");
			
			
			// --- Requete/Response
			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
		
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			// Recuperation données
			String output = response.getEntity(String.class);

			System.out.println("Output from Server .... \n");
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
