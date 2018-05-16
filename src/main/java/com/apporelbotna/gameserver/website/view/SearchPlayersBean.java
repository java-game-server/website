package com.apporelbotna.gameserver.website.view;

import java.io.Serializable;

import javax.inject.Inject;

import com.apporelbotna.gameserver.website.model.AuthenticatedUser;
import com.apporelbotna.gameserver.website.model.dao.WebsiteDAO;

public class SearchPlayersBean implements Serializable
{
	private static final long serialVersionUID = 4587278501997555354L;

	@Inject
	private AuthenticatedUser authenticatedUser;

	@Inject
	private transient WebsiteDAO websiteDAO;

}
