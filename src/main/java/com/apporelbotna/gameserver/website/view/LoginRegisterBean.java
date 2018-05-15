package com.apporelbotna.gameserver.website.view;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.apporelbotna.gameserver.stubs.Token;
import com.apporelbotna.gameserver.stubs.User;
import com.apporelbotna.gameserver.website.model.AuthenticatedUser;
import com.apporelbotna.gameserver.website.model.dao.WebsiteDAO;
import com.apporelbotna.gameserver.website.util.Faces;

@Named
@ViewScoped
public class LoginRegisterBean implements Serializable
{
	private static final long serialVersionUID = -3970262675842802311L;

	@Inject
	private AuthenticatedUser authenticatedUser;

	@Inject
	private transient WebsiteDAO websiteDAO;

	private String email;
	private String username;
	private String password;
	private String repeatedPassword;

	public String login()
	{
		Token token = websiteDAO.login(email, password);
		if (token == null)
		{
			Faces.error("Bad credentials");
			return null;
		}
		authenticatedUser.setUser(websiteDAO.getUserInformation(email));
		return "gameLibrary?faces-redirect=true";
	}

	public String register()
	{
		if (!password.equals(repeatedPassword))
		{
			Faces.error("The passwords do not match");
			return null;
		}
		if (websiteDAO.createUser(new User(email, username), password))
		{
			authenticatedUser.setUser(websiteDAO.getUserInformation(email));
			return "gameLibrary?faces-redirect=true";
		}

		Faces.error("There was an error while registering. Perhaps the user already exists?");
		return null;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public LoginRegisterBean()
	{
		// CDI constructor
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getRepeatedPassword()
	{
		return repeatedPassword;
	}

	public void setRepeatedPassword(String repeatedPassword)
	{
		this.repeatedPassword = repeatedPassword;
	}
}
