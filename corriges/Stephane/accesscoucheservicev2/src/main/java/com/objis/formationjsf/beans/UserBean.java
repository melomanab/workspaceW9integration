package com.objis.formationjsf.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.objis.formationjsf.domaine.User;
import com.objis.formationjsf.service.UserService;

/**
 * @author www.objis.com
 */

@ManagedBean(name="userbean")
@SessionScoped
public class UserBean {

	private User user = new User();
	
	// Constructeur
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public UserBean(User user) {
		super();
		this.user = user;
	}


	public UserBean() {
		super();
	}
	

	public Object appelTraitement() {  // la Signature (retour Object) est documentée dans doc JSF commandButton / attribut action
		
		UserService service = new UserService();
		String res = service.createUser(user);
		System.out.println("res = "+res);
		if (res == "true") {
		return "resultatOK";
		}
		return "resultatKO";
	}
	
}
