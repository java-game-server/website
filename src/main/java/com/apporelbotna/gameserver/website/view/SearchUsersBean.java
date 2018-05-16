package com.apporelbotna.gameserver.website.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.apporelbotna.gameserver.stubs.User;
import com.apporelbotna.gameserver.website.model.AuthenticatedUser;
import com.apporelbotna.gameserver.website.model.dao.WebsiteDAO;
import com.apporelbotna.gameserver.website.util.Faces;

@Named
@ViewScoped
public class SearchUsersBean implements Serializable
{
	private static final long serialVersionUID = 4587278501997555354L;

	@Inject
	private AuthenticatedUser authenticatedUser;

	@Inject
	private transient WebsiteDAO websiteDAO;

	private transient List<User> users;

	private transient List<User> filteredUsers;

	@PostConstruct
	private void init()
	{
		if( ! authenticatedUser.isLogged())
			Faces.redirect(LoginRegisterBean.PAGE_NAME);
		users = websiteDAO.findAllUser();
	}

	public List<User> getUsers()
	{
		return users;
	}

	public void setUsers(List<User> users)
	{
		this.users = users;
	}

	public List<User> getFilteredUsers()
	{
		return filteredUsers;
	}

	public void setFilteredUsers(List<User> filteredUsers)
	{
		this.filteredUsers = filteredUsers;
	}

	public void addFriend(User user)
	{
		Faces.info("You wanted to add the user " + user.getName()
								+ " to your friends. Sadly, this feature is not implemented yet!");
	}
}
