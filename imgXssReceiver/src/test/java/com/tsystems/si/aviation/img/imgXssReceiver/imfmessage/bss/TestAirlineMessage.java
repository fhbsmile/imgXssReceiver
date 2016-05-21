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

import com.tsystems.si.aviation.img.imgXssReceiver.imf.bss.AirlineMessage;

public class TestAirlineMessage {
	private static final Logger     logger               = LoggerFactory.getLogger(TestAirlineMessage.class);
	
	
	@Test
	public void testParseBssAirline(){
		String str =null;
		URL url = ConfigurationUtils.locate("airline.xml");
		try {
			 str = IOUtils.toString(url, "utf-8");
			 logger.info(str);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		AirlineMessage.parseBssAirline(str);
	}
	
	
}
