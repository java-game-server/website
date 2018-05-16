package com.apporelbotna.gameserver.website.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.apporelbotna.gameserver.stubs.User;
import com.apporelbotna.gameserver.stubs.UserType;
import com.apporelbotna.gameserver.website.model.AuthenticatedUser;
import com.apporelbotna.gameserver.website.model.dao.WebsiteDAO;
import com.apporelbotna.gameserver.website.util.Faces;

@Named
@ViewScoped
public class ManageUsersBean implements Serializable
{
	private static final long serialVersionUID = 4587278501997555354L;

	@Inject
	private AuthenticatedUser authenticatedUser;

	@Inject
	private transient WebsiteDAO websiteDAO;

	private transient User user;
	private boolean admin;
	private String password;

	@PostConstruct
	public void init()
	{
		if( ! (authenticatedUser.isLogged() && authenticatedUser.isAdmin()) )
			Faces.redirect(LoginRegisterBean.PAGE_NAME);
		user = new User();
	}

	public void create()
	{
		User newUser = new User(
				user.getEmail(),
				user.getName(),
				user.getGold(),
				admin ? UserType.ADMIN : UserType.USER);

		if (websiteDAO.createUser(newUser, password))
			Faces.info("User created successfully!");
		else
			Faces.error("Error creating user. Maybe it's already registered?");
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
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
		return admin;
	}

	public void setAdmin(boolean admin)
	{
		this.admin = admin;
	}
}
