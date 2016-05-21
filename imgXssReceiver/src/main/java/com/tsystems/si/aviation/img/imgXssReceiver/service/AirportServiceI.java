package com.tsystems.si.aviation.img.imgXssReceiver.service;



import com.tsystems.si.aviation.img.imgXssReceiver.bean.RefAirport;

public interface  AirportServiceI {
   
	public void saveOrUpdate(RefAirport flight);
	
	public void delete(RefAirport flight);
}
