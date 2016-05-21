package com.tsystems.si.aviation.img.imgXssReceiver.utils;


import java.util.Date;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TestDateHandle {
	private static final Logger     logger               = LoggerFactory.getLogger(TestDateHandle.class);
	
	
	@Test
	public void testGetStringByDate(){
          logger.info("Current Time :{}", DateHandle.getStringByDate_fmtStandardDate(new Date()));
	}
	
	
}
