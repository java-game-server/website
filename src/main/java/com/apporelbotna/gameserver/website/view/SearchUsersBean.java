package com.apporelbotna.gameserver.website.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.apporelbotna.gameserver.stubs.User;
import com.apporelbotna.gameserver.website.model.AuthenticatedUser;
import com.apporelbotna.gameserver.website.model.dao.WebsiteDAO;
import com.apporelbotna.gameserver.website.util.Faces;

public class SearchUsersBean implements Serializable
{
	private static final long serialVersionUID = 4587278501997555354L;

	@Inject
	private AuthenticatedUser authenticatedUser;

	@Inject
	private transient WebsiteDAO websiteDAO;

	private List<User> users;

	@PostConstruct
	private void init()
	{
		if( ! authenticatedUser.isLogged())
			Faces.redirect(LoginRegisterBean.PAGE_NAME);
		users = new ArrayList<>();
	}

}
