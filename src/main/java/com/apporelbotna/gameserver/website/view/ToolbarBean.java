package com.apporelbotna.gameserver.website.view;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.apporelbotna.gameserver.website.model.AuthenticatedUser;

@Named
@ApplicationScoped
public class ToolbarBean
{
	@Inject
	private AuthenticatedUser authenticatedUser;

	public ToolbarBean()
	{
		// CDI Constructor
	}

	public String logout()
	{
		authenticatedUser.setUser(null);
		return "login?faces-redirect=true";
	}
}
