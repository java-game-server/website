package com.apporelbotna.gameserver.website.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.apporelbotna.gameserver.stubs.Game;

@ApplicationScoped
public class DummyGameFactory
{
	public DummyGameFactory()
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
							"pbs.twimg.com/profile_images/664270316152217601/VdrCsCKg.jpg"));
		}

		return games;
	}
}
