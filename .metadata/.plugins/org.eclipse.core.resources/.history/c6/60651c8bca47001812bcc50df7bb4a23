package presentation;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import domaine.Client;
import service.ServiceClient;

@ManagedBean(name = "userbean")

public class UserBean {

	//////////// Proprietes ////////////////
	
	// 1. Declaration de classe domaine.Client comme proprietée du beans
	// et instatiation immediate à celle du bean
	private Client client = new Client();

	// 2. Constructeur
	public UserBean(Client client) {
		super();
		this.client = client;
	}

	public UserBean() {
		super();
	}

	// 3. Getter/Setter pour proprieté client
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	//////////// Methodes ////////////////

	public Object appelTraitement() {

		// la Signature (retour Object) est documentée dans doc JSF commandButton /
		// attribut action

		// 1. Instantiation service
		ServiceClient serviceC = new ServiceClient();

		// 2. Appel services depuis le bean

		// ----- INSERT a partir de formulaire

		boolean res = serviceC.createNewClient(client);

		if (res) {
			return "resultatOK";
		}
		return "resultatKO";
	}

}
