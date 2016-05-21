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
import com.tsystems.si.aviation.img.imgXssReceiver.bean.XmlMessageLog;
import com.tsystems.si.aviation.img.imgXssReceiver.dao.MessageLogDaoI;
import com.tsystems.si.aviation.img.imgXssReceiver.dao.XmlMessageLogDaoI;
import com.tsystems.si.aviation.img.imgXssReceiver.service.AirlineServiceI;
import com.tsystems.si.aviation.img.imgXssReceiver.service.MessageLogServiceI;
import com.tsystems.si.aviation.img.imgXssReceiver.service.XmlMessageLogServiceI;


@Service
public class XmlMessageLogServiceImpl implements XmlMessageLogServiceI {
	private static final Logger     logger               = LoggerFactory.getLogger(XmlMessageLogServiceImpl.class);
	@Autowired
    private XmlMessageLogDaoI XmlMessageLogDao;
	@Override
	public void save(XmlMessageLog xmlMessageLog) {
		// TODO Auto-generated method stub

			logger.info("Insert new Xml Message Log ......");
			XmlMessageLogDao.save(xmlMessageLog);
			
			logger.info("Insert new Xml Message Log Success......");

	}


}
