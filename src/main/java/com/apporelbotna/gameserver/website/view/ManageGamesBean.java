package com.apporelbotna.gameserver.website.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.apporelbotna.gameserver.stubs.Game;
import com.apporelbotna.gameserver.website.model.AuthenticatedUser;
import com.apporelbotna.gameserver.website.model.dao.WebsiteDAO;
import com.apporelbotna.gameserver.website.util.Faces;

@Named
@ViewScoped
public class ManageGamesBean implements Serializable
{
	private static final long serialVersionUID = 4587278501997555354L;

	@Inject
	private AuthenticatedUser authenticatedUser;

	@Inject
	private transient WebsiteDAO websiteDAO;

	private transient Game game;

	@PostConstruct
	public void init()
	{
		if( ! (authenticatedUser.isLogged() && authenticatedUser.isAdmin()) )
			Faces.redirect(LoginRegisterBean.PAGE_NAME);
		game = new Game();
	}

	public void create()
	{
		if (websiteDAO.createGame(game))
			Faces.info("Game created successfully!");
		else
			Faces.error("Error creating game. It might be already created!");
	}

	public Game getGame()
	{
		return game;
	}

	public void setGame(Game game)
	{
		this.game = game;
	}
}
