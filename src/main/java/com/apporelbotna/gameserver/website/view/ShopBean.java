package com.apporelbotna.gameserver.website.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.apporelbotna.gameserver.stubs.Game;
import com.apporelbotna.gameserver.stubs.User;
import com.apporelbotna.gameserver.website.model.AuthenticatedUser;
import com.apporelbotna.gameserver.website.model.dao.WebsiteDAO;
import com.apporelbotna.gameserver.website.util.Faces;

@Named
@ViewScoped
public class ShopBean implements Serializable
{
	private static final long serialVersionUID = 4350005646755352314L;

	@Inject
	private WebsiteDAO dao;

	@Inject
	private AuthenticatedUser authenticatedUser;

	private transient Game selectedGame;
	private transient List<Game> games;

	@PostConstruct
	public void init()
	{
		if( ! authenticatedUser.isLogged())
			Faces.redirect(LoginRegisterBean.PAGE_NAME);
		games = dao.getAllGames();
	}

	public List<Game> getGames()
	{
		return games;
	}

	public void setGames(List<Game> games)
	{
		this.games = games;
	}

	public AuthenticatedUser getAuthenticatedUser()
	{
		return authenticatedUser;
	}

	public void setAuthenticatedUser(AuthenticatedUser authenticatedUser)
	{
		this.authenticatedUser = authenticatedUser;
	}

	public Game getSelectedGame()
	{
		return selectedGame;
	}

	public void setSelectedGame(Game selectedGame)
	{
		this.selectedGame = selectedGame;
	}

	public void buy(Game game)
	{
		if(dao.storeGameToUser(authenticatedUser.getUser(), game.getId()))
		{
			User user = authenticatedUser.getUser();
			user.setGold(user.getGold() - game.getPrice());
			Faces.info("You bought " + game.getName() + " for " + game.getPrice() + " golds!");
		}
		else
			Faces.error("You don't have enough money for this game, poor bastard!");
	}
}
