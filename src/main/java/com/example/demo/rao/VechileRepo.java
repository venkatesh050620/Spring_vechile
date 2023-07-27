package com.example.demo.rao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.module.Vechile;

public interface VechileRepo extends JpaRepository<Vechile, Integer> 
{
	@Query(value="select * from Vechile where vcolor=?1",nativeQuery = true)
	List<Vechile> findByVcolour(String vcolour);
	
	@Query(value="select * from Vechile",nativeQuery = true)
	List<Vechile> findAllVehicle();
	
	@Query(value="select * from Vechile order by vprice asc",nativeQuery = true)
	List<Vechile> SortedPrice();
	
	@Query(value="select * from Vechile where vprice>1000000",nativeQuery = true)
	List<Vechile> findByGreater(double vprice);
	
	@Query(value="select * from Vechile order by vprice asc,vcolour asc",nativeQuery = true)
	List<Vechile> findByVcolor(String vcolor);
}
