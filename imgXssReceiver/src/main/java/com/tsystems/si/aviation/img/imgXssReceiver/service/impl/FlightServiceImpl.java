package com.tsystems.si.aviation.img.imgXssReceiver.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsystems.si.aviation.img.imgXssReceiver.bean.Flightinfo;
import com.tsystems.si.aviation.img.imgXssReceiver.dao.FlighinfoDaoI;
import com.tsystems.si.aviation.img.imgXssReceiver.service.FlightServiceI;


@Service
public class FlightServiceImpl implements FlightServiceI {
	private static final Logger     logger               = LoggerFactory.getLogger(FlightServiceImpl.class);
	@Autowired
    private FlighinfoDaoI flightinfoDao;
	@Override
	public void saveOrUpdate(Flightinfo flight) {
		// TODO Auto-generated method stub
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("flightIdentity", flight.getFlightIdentity());
		params.put("flightScheduledDate", flight.getFlightScheduledDate());
		params.put("flightDirection", flight.getFlightDirection());
		String sql = "from Flightinfo f where f.flightIdentity = :flightIdentity and f.flightScheduledDate=:flightScheduledDate and f.flightDirection =:flightDirection";
		List<Flightinfo> flights =flightinfoDao.find(sql, params);
		
		if(flights.isEmpty()){
			logger.info("Can not find the flight to update, insert new flight......");
			flightinfoDao.save(flight);
			logger.info("Insert new flight success......");
		}else{
			logger.info("find the flight to update, update old flight......");
			Flightinfo flightQ = flights.get(0);
			logger.info("Old flight :{}",flightQ.toString());
			logger.info("New flight :{}",flight.toString());
			String[] a = {"id","createtime"};
	        BeanUtils.copyProperties(flight, flightQ,a);
	        flightinfoDao.update(flightQ);
	        logger.info("update old flight success......");
		}
	}

	@Override
	public void delete(Flightinfo flight) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("flightIdentity", flight.getFlightIdentity());
		params.put("flightScheduledDate", flight.getFlightScheduledDate());
		params.put("flightDirection", flight.getFlightDirection());
		String sql = "from Flightinfo f where f.flightIdentity = :flightIdentity and f.flightScheduledDate=:flightScheduledDate and f.flightDirection =:flightDirection";
		List<Flightinfo> flights =flightinfoDao.find(sql, params);
		if(flights.isEmpty()){
			logger.error("Can not find the flight to delete!!!! Ingnore delete message!");
		}else{
			logger.info("Flight is deleting........");
          for(Flightinfo flightQ: flights){
        	  flightinfoDao.delete(flightQ);
          }
          logger.info("Flight delete success........");
		}
	}

}
