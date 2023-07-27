package com.example.demo.Serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.ResourceNotFound;
import com.example.demo.Services.VechileServices;
import com.example.demo.module.Vechile;
import com.example.demo.rao.VechileRepo;

import ch.qos.logback.core.joran.conditional.ElseAction;
@Service
public class VechileServiceimpl implements VechileServices 
{
	@Autowired
	VechileRepo repo;

	@Override
	public Vechile addVechile(Vechile v) {
		return repo.save(v);
	}

	@Override
	public Vechile updateVechile(Vechile v) {
		Vechile v1=repo.findById(v.getVid()).orElse(null);
		if(v1!=null)
		{
			v1.setVname(v1.getVname());
			v1.setVcolor(v1.getVcolor());
			v1.setVmodel(v1.getVmodel());
			v1.setVprice(v1.getVprice());
			return repo.save(v1);
			
		}
		else {
			throw new ResourceNotFound("Vechile","id", v.getVid());
		}
	}

	@Override
	public Vechile getById(Integer vid) {
		return repo.findById(vid).orElseThrow(()-> new ResourceNotFound("Vechile","id", vid));
	}

	@Override
	public List<Vechile> getByVcolour(String vcolour) {
		return repo.findByVcolour(vcolour);
	}

	@Override
	public List<Vechile> getAllVehicle() {
		return repo.findAllVehicle();
	}

	@Override
	public Vechile deleteById(Integer vid) {
		Vechile v=repo.findById(vid).orElse(null);
		if(v!=null)
		{
			repo.deleteById(vid);
			return v;
		}
		else {
			throw new ResourceNotFound("Vechile", "id", v);
		}
		
	}

	@Override
	public List<Vechile> getSortedPrice() 
	{
		
		return repo.SortedPrice();
	}

	@Override
	public List<Vechile> getPriceGreaterThan(double price) {
		return repo.findByGreater(price);
	}
	@Override
	public List<Vechile> getSortedPriceAndColour() {
		return null ;
	}

}
