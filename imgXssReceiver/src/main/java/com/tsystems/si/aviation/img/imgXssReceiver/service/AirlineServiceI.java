package com.tsystems.si.aviation.img.imgXssReceiver.service;


import com.tsystems.si.aviation.img.imgXssReceiver.bean.RefAirline;

public interface  AirlineServiceI {
   
	public void saveOrUpdate(RefAirline flight);
	
	public void delete(RefAirline flight);
}
