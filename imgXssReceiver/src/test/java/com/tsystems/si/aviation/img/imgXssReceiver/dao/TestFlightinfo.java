package com.tsystems.si.aviation.img.imgXssReceiver.dao;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tsystems.si.aviation.img.imgXssReceiver.bean.Flightinfo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml"})
public class TestFlightinfo {
	private static final Logger     logger               = LoggerFactory.getLogger(TestFlightinfo.class);
	@Autowired
	private FlighinfoDaoI FlighinfoDao;


	@Test
	public void testSave() {
        Flightinfo flight = new Flightinfo();
        flight.setFlightIdentity("MU1003");
        flight.setFlightDirection("A");
        flight.setFlightScheduledDate(new Date());
        flight.setCreatetime("2015-06-16 16:46:00");
        flight.setFlightScheduledDateTime(new Date());
        FlighinfoDao.save(flight);
        
	}
	
	@Test
	public void testGet(){
		
		 Flightinfo flight =FlighinfoDao.get(Flightinfo.class, 235183);
		logger.info(flight.toString());
		
	}
	
	@Test
	public void testUpdate(){
		
		 Flightinfo flight =FlighinfoDao.get(Flightinfo.class, 235183);
	        Flightinfo flight1 = new Flightinfo();
	        flight1.setFlightIdentity("MU1003");
	        flight1.setFlightDirection("A");
	        flight1.setFlightScheduledDate(new Date());
	        flight1.setCreatetime("2015-06-16 16:46:00");
	        flight1.setFlightScheduledDateTime(new Date());
	        logger.info("Before copy:  {}",flight.toString());
	        String[] a = {"id"};
	        BeanUtils.copyProperties(flight1, flight,a);
		 //flight.setFlightDirection("D");
		 FlighinfoDao.update(flight);
	        logger.info("After copy:  {}",flight.toString());
		
		
		
	}

}
