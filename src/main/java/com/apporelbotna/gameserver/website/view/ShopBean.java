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

@Named
@ViewScoped
public class ShopBean implements Serializable
{

    private static final long serialVersionUID = 4350005646755352314L;

    private List< Game > games;

    @Inject
    private WebsiteDAO dao;

    @Inject
    private AuthenticatedUser authenticatedUser;

    public ShopBean()
    {
	// CDI constructor
    }

    @PostConstruct
    public void init()
    {

	games = dao.getAllGames();
	for ( Game game : games )
	{
	    System.out.println( game );
	}
    }

    public List< Game > getGames()
    {
	return games;
    }

    public void setGames(List< Game > games)
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

}
