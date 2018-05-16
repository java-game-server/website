package com.apporelbotna.gameserver.website.view;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.apporelbotna.gameserver.stubs.User;
import com.apporelbotna.gameserver.stubs.UserType;
import com.apporelbotna.gameserver.website.model.AuthenticatedUser;
import com.apporelbotna.gameserver.website.model.dao.WebsiteDAO;

@Named
@ViewScoped
public class CreateUserBean implements Serializable
{
	private static final long serialVersionUID = 4587278501997555354L;

	@Inject
	private AuthenticatedUser authenticatedUser;

	@Inject
	private transient WebsiteDAO websiteDAO;

	private String email;
	private String name;
	private String password;
	private boolean isAdmin;
	private float gold;

	public String create()
	{
		System.out.println(email);
		System.out.println(name);
		System.out.println(password);
		System.out.println(isAdmin);
		System.out.println(gold);

		UserType useType = isAdmin ? UserType.ADMIN : UserType.USER;

		User user = new User(email, name, gold, useType);
		if (websiteDAO.createUser(user, password))
		{
			System.out.println("user Stored");
			//TODO dar feedback
		}

		return null;
		// return "gameLibrary?faces-redirect=true";
	}

	public AuthenticatedUser getAuthenticatedUser()
	{
		return authenticatedUser;
	}

	public void setAuthenticatedUser(AuthenticatedUser authenticatedUser)
	{
		this.authenticatedUser = authenticatedUser;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public boolean isAdmin()
	{
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin)
	{
		this.isAdmin = isAdmin;
	}

	public float getGold()
	{
		return gold;
	}

	public void setGold(float gold)
	{
		this.gold = gold;
	}

}
