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




	@Override
	public String toString() {
		return "UserBean [user=" + user.getNom() + "]";
	}


	public UserBean() {
		super();
	}
	

	public Object appelTraitement() {  // la Signature (retour Object) est document�e dans doc JSF commandButton / attribut action
		
		UserService service = new UserService();
		System.out.println(user.getNom());
	 String result = service.createUser(user);
	 System.out.println("le resultati UserBean" + result);
	String valderetourOK = "ok true";
	System.out.println(valderetourOK);
	System.out.println(result);
	 if (result.equals(valderetourOK)) {
			return "resultatOK";
	 }else {
	 return "resultatKO";

	}
	 }
	
}
