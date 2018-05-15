package com.apporelbotna.gameserver.website.view;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.apporelbotna.gameserver.website.util.Faces;

@Named
@ViewScoped
public class LoginRegisterBean implements Serializable
{
	private static final long serialVersionUID = -3970262675842802311L;

	private String username;
	private String password;
	private String repeatedPassword;

	public String login()
	{
		if(username.equals("admin")) // TODO replace for WS call
		{
			return "gameLibrary?faces-redirect=true";
		}
		Faces.error("Bad credentials");
		return null;
	}

	public String register()
	{
		if( ! password.equals(repeatedPassword))
		{
			Faces.error("The passwords do not match");
			return null;
		}

		if(username.equals("admin")) // TODO Replace for WS call
			return "gameLibrary?faces-redirect=true";
		return null;
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
