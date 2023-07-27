package com.example.demo.Services;

import java.util.List;

import com.example.demo.module.Vechile;

public interface VechileServices
{
	Vechile addVechile(Vechile v);
	
	
	
	
	Vechile getById(Integer vid);

	List<Vechile> getByVcolour(String vcolour);

	List<Vechile> getAllVehicle();

	//Vechile updateVehicle(Vechile v); 

	Vechile deleteById(Integer vid);

	List<Vechile> getSortedPrice();

	List<Vechile>getPriceGreaterThan(double price);

	List<Vechile> getSortedPriceAndColour();

	Vechile updateVechile(Vechile v);

}
