package com.apporelbotna.gameserver.website.view;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.apporelbotna.gameserver.persistencewsclient.GameDAO;
import com.apporelbotna.gameserver.stubs.Token;
import com.apporelbotna.gameserver.stubs.User;
import com.apporelbotna.gameserver.website.model.AuthenticatedUser;
import com.apporelbotna.gameserver.website.util.Faces;

@Named
@ViewScoped
public class LoginRegisterBean implements Serializable
{
    private static final long serialVersionUID = -3970262675842802311L;

    private String email;
    private String username;
    private String password;
    private String repeatedPassword;

    @Inject
    private AuthenticatedUser authenticatedUser;

    private GameDAO dao = new GameDAO();

    public String login()
    {
	Token token = dao.login( email, password );
	if ( token == null )
	{
	    System.out.println( "invalid credentials" );
	    // invalid crendentials
	    Faces.error( "Bad credentials" );
	    return null;
	}
	authenticatedUser.setUser( dao.getUserInformation( email ) );

	if ( authenticatedUser.isAdmin() )
	{
	    // user is admin
	    System.out.println( "is admin" );
	    return "gameLibrary?faces-redirect=true";
	} else
	{
	    // user is normal user
	    System.out.println( "is normal user" );
	}
	Faces.error( "Bad credentials" );
	return null;
    }

    public String register()
    {
	if ( !password.equals( repeatedPassword ) )
	{
	    Faces.error( "The passwords do not match" );
	    return null;
	}
	if ( dao.createUser( new User( email, username ), password ) )
	{
	    // usuario registrado
	}

	return null;
    }

    public String getEmail()
    {
	return email;
    }

    public void setEmail(String email)
    {
	this.email = email;
    }

    public LoginRegisterBean()
    {
	// CDI constructor
    }

    public String getUsername()
    {
	return username;
    }

    public void setUsername(String username)
    {
	this.username = username;
    }

    public String getPassword()
    {
	return password;
    }

    public void setPassword(String password)
    {
	this.password = password;
    }

    public String getRepeatedPassword()
    {
	return repeatedPassword;
    }

    public void setRepeatedPassword(String repeatedPassword)
    {
	this.repeatedPassword = repeatedPassword;
    }
}
