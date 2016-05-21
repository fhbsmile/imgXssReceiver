package com.tsystems.si.aviation.img.imgXssReceiver.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsystems.si.aviation.img.imgXssReceiver.bean.MessageLog;
import com.tsystems.si.aviation.img.imgXssReceiver.dao.MessageLogDaoI;
import com.tsystems.si.aviation.img.imgXssReceiver.service.AirlineServiceI;
import com.tsystems.si.aviation.img.imgXssReceiver.service.MessageLogServiceI;


@Service
public class MessageLogServiceImpl implements MessageLogServiceI {
	private static final Logger     logger               = LoggerFactory.getLogger(MessageLogServiceImpl.class);
	@Autowired
    private MessageLogDaoI messageLogDao;
	@Override
	public void save(MessageLog messageLog) {
		// TODO Auto-generated method stub

			logger.info("Insert new messageLog ......");
			messageLogDao.save(messageLog);
			
			logger.info("Insert new messageLog success......");

	}


}
