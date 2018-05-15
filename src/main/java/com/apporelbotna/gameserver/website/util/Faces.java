package com.apporelbotna.gameserver.website.util;

import javax.faces.application.FacesMessage;
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
}
