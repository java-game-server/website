package com.apporelbotna.gameserver.website.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.apporelbotna.gameserver.stubs.Game;
import com.apporelbotna.gameserver.website.model.AuthenticatedUser;
import com.apporelbotna.gameserver.website.model.dao.WebsiteDAO;
import com.apporelbotna.gameserver.website.service.DummyGameFactory;
import com.apporelbotna.gameserver.website.util.Faces;

@Named
@ViewScoped
public class GameLibraryBean implements Serializable
{
    private static final long serialVersionUID = -2966068452310876590L;

    @Inject
    AuthenticatedUser authenticatedUser;

    @Inject
    private WebsiteDAO websiteDAO;

    @Inject
    private DummyGameFactory dummyGameFactory;

    private List< Game > games;
    private Game selectedGame;

    public GameLibraryBean()
    {
	// CDI
    }

    @PostConstruct
    public void init()
    {
	// games = dummyGameFactory.createGames(50);
	games = websiteDAO.findAllGamesByUser( authenticatedUser.getUser());
    }

    public List< Game > getGames()
    {
	return games;
    }

    public Game getSelectedGame()
    {
	return selectedGame;
    }

    public void setSelectedGame(Game selectedGame)
    {
	this.selectedGame = selectedGame;
    }

    public void play()
    {
	Faces.error( "Oops!", "Could not found " + selectedGame.getName() + "... Sorry!" );
    }
}
