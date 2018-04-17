package com.apporelbotna.gameserver.website.service;

import java.util.Random;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RandomNumberGenerator
{
	public RandomNumberGenerator()
	{
		// NO PROBLEM MAN
	}

	public int generateRandomNumber()
	{
		Random random = new Random();
		return random.nextInt(10);
	}
}
