package com.apporelbotna.gameserver.website.model;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.apporelbotna.gameserver.stubs.Game;
import com.apporelbotna.gameserver.stubs.User;

@Named
@ApplicationScoped
public class AuthenticatedUser
{
	private User user;

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public List<Game> getGames()
	{
		return user.getGames();
	}

	public boolean isAdmin()
	{
		return user.isAdmin();
	}

	public boolean isLogged()
	{
		return user != null;
	}
}
