package com.apporelbotna.gameserver.website.service;

import java.util.List;

import com.apporelbotna.gameserver.stubs.Game;
import com.apporelbotna.gameserver.stubs.User;

public interface GameFactory
{
	List<Game> provideGames(int n);
	List<Game> provideAllGames();
	List<Game> provideGames(User user);
}
