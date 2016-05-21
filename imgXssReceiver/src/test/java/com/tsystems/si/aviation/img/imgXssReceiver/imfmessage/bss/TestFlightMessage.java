package com.tsystems.si.aviation.img.imgXssReceiver.imfmessage.bss;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.configuration.ConfigurationUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tsystems.si.aviation.img.imgXssReceiver.imf.fss.FlightMessage;

public class TestFlightMessage {
	private static final Logger     logger               = LoggerFactory.getLogger(TestFlightMessage.class);
	
	
	@Test
	public void testParseFssFlight(){
		String str =null;
		//URL url = ConfigurationUtils.locate("flight_arrival.xml");
		//URL url = ConfigurationUtils.locate("flight_departure.xml");
		URL url = ConfigurationUtils.locate("flight_del.xml");
		try {
			 str = IOUtils.toString(url, "utf-8");
			 logger.info(str);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		FlightMessage.parseFssFlight(str);
	}
	
	
}
