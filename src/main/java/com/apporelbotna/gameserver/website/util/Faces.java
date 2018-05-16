package com.apporelbotna.gameserver.website.util;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class Faces
{
	private Faces()
	{
		throw new UnsupportedOperationException("Can't instantiate an utility class");
	}

	public static void info(String msg)
	{
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public static void info(String summary, String detail)
	{
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public static void warning(String msg)
	{
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, msg, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public static void warning(String summary, String detail)
	{
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public static void error(String msg)
	{
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public static void error(String summary, String detail)
	{
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public static void redirect(String newPageName)
	{
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		try
		{
			context.redirect(context.getRequestContextPath() + "/views/" + newPageName + ".xhtml");
		}
		catch (IOException e)
		{
			throw new RuntimeException("Could not redirect to " + newPageName);
		}
	}
}
