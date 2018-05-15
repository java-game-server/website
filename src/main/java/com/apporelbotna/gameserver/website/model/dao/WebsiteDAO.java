package com.apporelbotna.gameserver.website.model.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.apporelbotna.gameserver.persistencewsclient.GameDAO;
import com.apporelbotna.gameserver.stubs.Game;
import com.apporelbotna.gameserver.stubs.Match;
import com.apporelbotna.gameserver.stubs.RankingPointsTO;
import com.apporelbotna.gameserver.stubs.Token;
import com.apporelbotna.gameserver.stubs.User;

@ApplicationScoped
public class WebsiteDAO
{
	private GameDAO gameDAO = new GameDAO();

	public WebsiteDAO()
	{
		// CDI
	}

	public boolean createGame(Game game)
	{
	    return gameDAO.createGame( game );
	}

	public boolean createUser(User user, String password)
	{
	    return gameDAO.createUser( user, password );
	}

	@Override
	public boolean equals(Object arg0)
	{
	    return gameDAO.equals( arg0 );
	}

	public List< Game > findAllGamesByUser(User user)
	{
	    return gameDAO.findAllGamesByUser( user );
	}

	public List< Game > findGamesLikeName(String userInput)
	{
	    return gameDAO.findGamesLikeName( userInput );
	}

	public List< User > findUsersLikeEmail(String userInput)
	{
	    return gameDAO.findUsersLikeEmail( userInput );
	}

	public List< User > findUsersLikeName(String userInput)
	{
	    return gameDAO.findUsersLikeName( userInput );
	}

	public boolean finishMatch(Match... matches)
	{
	    return gameDAO.finishMatch( matches );
	}

	public float gameTimePlayedByGame(String email, int gameID)
	{
	    return gameDAO.gameTimePlayedByGame( email, gameID );
	}

	public List< Game > getAllGames()
	{
	    return gameDAO.getAllGames();
	}

	public List< String > getAllGenre()
	{
	    return gameDAO.getAllGenre();
	}

	public List< RankingPointsTO > getRankingPointsByGameAndUser(int gameId)
	{
	    return gameDAO.getRankingPointsByGameAndUser( gameId );
	}

	public User getUserInformation(String email)
	{
	    return gameDAO.getUserInformation( email );
	}

	@Override
	public int hashCode()
	{
	    return gameDAO.hashCode();
	}

	public boolean isUserLoggeable(String email, String tokenString)
	{
	    return gameDAO.isUserLoggeable( email, tokenString );
	}

	public Token login(String email, String password)
	{
	    return gameDAO.login( email, password );
	}

	public void storeGameToUser(User user, int idGame)
	{
	    gameDAO.storeGameToUser( user, idGame );
	}

	@Override
	public String toString()
	{
	    return gameDAO.toString();
	}

	public void updateUserBasicInformatio(User user)
	{
	    gameDAO.updateUserBasicInformatio( user );
	}

	public User validateUser(String email, String tokenString)
	{
	    return gameDAO.validateUser( email, tokenString );
	}
}
