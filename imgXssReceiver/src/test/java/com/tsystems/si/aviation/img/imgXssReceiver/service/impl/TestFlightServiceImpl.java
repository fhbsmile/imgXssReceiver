package com.tsystems.si.aviation.img.imgXssReceiver.service.impl;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.configuration.ConfigurationUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tsystems.si.aviation.img.imgXssReceiver.bean.Flightinfo;
import com.tsystems.si.aviation.img.imgXssReceiver.dao.FlighinfoDaoI;
import com.tsystems.si.aviation.img.imgXssReceiver.imf.fss.FlightMessage;
import com.tsystems.si.aviation.img.imgXssReceiver.service.FlightServiceI;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml"})
public class TestFlightServiceImpl{
	private static final Logger     logger               = LoggerFactory.getLogger(TestFlightServiceImpl.class);
	@Autowired
    private FlightServiceI flightinfoService;
   @Test
	public void testSaveOrUpdate() {
		// TODO Auto-generated method stub
		String str =null;
		URL url = ConfigurationUtils.locate("flight_arrival.xml");
		//URL url = ConfigurationUtils.locate("flight_departure.xml");
		//URL url = ConfigurationUtils.locate("flight_del.xml");
		//URL url = ConfigurationUtils.locate("fssHeartBeat_offline.xml");
		//URL url = ConfigurationUtils.locate("fssHeartBeat_on.xml");
		try {
			 str = IOUtils.toString(url, "utf-8");
			 logger.info(str);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Flightinfo flight =FlightMessage.parseFssFlight(str);
		flightinfoService.saveOrUpdate(flight);

	}

@Test
	public void testDelete() {
	    String str =null;
		URL url = ConfigurationUtils.locate("flight_arrival.xml");
		//URL url = ConfigurationUtils.locate("flight_departure.xml");
		//URL url = ConfigurationUtils.locate("flight_del.xml");
		//URL url = ConfigurationUtils.locate("fssHeartBeat_offline.xml");
		//URL url = ConfigurationUtils.locate("fssHeartBeat_on.xml");
		try {
			 str = IOUtils.toString(url, "utf-8");
			 logger.info(str);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Flightinfo flight =FlightMessage.parseFssFlight(str);
		flightinfoService.delete(flight);

	}

}
