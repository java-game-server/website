package com.apporelbotna.gameserver.website.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.PieChartModel;

import com.apporelbotna.gameserver.website.service.RandomNumberGenerator;

@Named
@ViewScoped
public class GreetBean implements Serializable
{
	private static final long serialVersionUID = -2518918999040352249L;

	@Inject
	private RandomNumberGenerator randomNumberGenerator;

	private PieChartModel pieModel1;
	private PieChartModel pieModel2;
	private String greet;

	public GreetBean()
	{
		/* CDI tonto */
	}

	@PostConstruct
	private void init()
	{
		greet = "Hello world! " + randomNumberGenerator.generateRandomNumber();
		createPieModels();
	}

	public String getGreet()
	{
		return greet;
	}

	public void setGreet(String greet)
	{
		this.greet = greet;
	}

	public PieChartModel getPieModel1()
	{
		return pieModel1;
	}

	public PieChartModel getPieModel2()
	{
		return pieModel2;
	}

	private void createPieModels()
	{
		createPieModel1();
		createPieModel2();
	}

	private void createPieModel1()
	{
		pieModel1 = new PieChartModel();
		pieModel1.set("Brand 1", 540);
		pieModel1.set("Brand 2", 325);
		pieModel1.set("Brand 3", 702);
		pieModel1.set("Brand 4", 421);
		pieModel1.setTitle("Simple Pie");
		pieModel1.setLegendPosition("w");
	}

	private void createPieModel2()
	{
		pieModel2 = new PieChartModel();
		pieModel2.set("Brand 1", 540);
		pieModel2.set("Brand 2", 325);
		pieModel2.set("Brand 3", 702);
		pieModel2.set("Brand 4", 421);
		pieModel2.setTitle("Custom Pie");
		pieModel2.setLegendPosition("e");
		pieModel2.setFill(false);
		pieModel2.setShowDataLabels(true);
		pieModel2.setDiameter(150);
	}
}
