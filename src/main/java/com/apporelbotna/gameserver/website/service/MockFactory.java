package com.apporelbotna.gameserver.website.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.apporelbotna.gameserver.stubs.Game;
import com.apporelbotna.gameserver.stubs.User;

@ApplicationScoped
public class MockFactory
{
	@Inject
	private RandomNumberGenerator rng;

	public MockFactory()
	{
		// CDI
	}

	public List<Game> createGames(int n)
	{
		List<Game> games = new ArrayList<>();
		for(int i = 1; i <= n ; i++)
		{
			games.add(
					new Game(i,
							"Warrona",
							"Bastante boa la vericita elleot me la follaba",
							"6969696996.exe",
							"http://pbs.twimg.com/profile_images/664270316152217601/VdrCsCKg.jpg"));
		}

		return games;
	}

	public List<User> createUsers(int n)
	{
		List<User> users = new ArrayList<>();
		for(int i = 1; i <= n; i++)
		{
			User user = new User(i + "dummyuser@warra.com", "Name: " +i);
			user.setGold(rng.generateRandomNumber(1000));
			users.add(user);
		}

		return users;
	}
}
