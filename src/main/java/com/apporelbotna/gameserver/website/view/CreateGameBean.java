package com.apporelbotna.gameserver.website.view;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.apporelbotna.gameserver.stubs.Game;
import com.apporelbotna.gameserver.website.model.AuthenticatedUser;
import com.apporelbotna.gameserver.website.model.dao.WebsiteDAO;

@Named
@ViewScoped
public class CreateGameBean implements Serializable
{
	private static final long serialVersionUID = 4587278501997555354L;

	@Inject
	private AuthenticatedUser authenticatedUser;

	@Inject
	private transient WebsiteDAO websiteDAO;

	private String name;
	private String description;
	private String executableName;
	private String imgUri;
	private float price;


	public String create()
	{
		System.out.println(name);
		System.out.println(description);
		System.out.println(executableName);
		System.out.println(imgUri);
		System.out.println(price);

		if(websiteDAO.createGame(new Game(null, name, description, executableName, imgUri, price))) {
			System.out.println("game Stored");
		}

		return null;
//		return "gameLibrary?faces-redirect=true";
	}

	public AuthenticatedUser getAuthenticatedUser()
	{
		return authenticatedUser;
	}

	public void setAuthenticatedUser(AuthenticatedUser authenticatedUser)
	{
		this.authenticatedUser = authenticatedUser;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getExecutableName()
	{
		return executableName;
	}

	public void setExecutableName(String executableName)
	{
		this.executableName = executableName;
	}

	public String getImgUri()
	{
		return imgUri;
	}

	public void setImgUri(String imgUri)
	{
		this.imgUri = imgUri;
	}

	public float getPrice()
	{
		return price;
	}

	public void setPrice(float price)
	{
		this.price = price;
	}
}
