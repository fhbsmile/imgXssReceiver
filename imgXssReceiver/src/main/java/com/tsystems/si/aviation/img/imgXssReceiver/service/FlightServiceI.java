package com.tsystems.si.aviation.img.imgXssReceiver.service;

import com.tsystems.si.aviation.img.imgXssReceiver.bean.Flightinfo;

public interface  FlightServiceI {
   
	public void saveOrUpdate(Flightinfo flight);
	
	public void delete(Flightinfo flight);
}
