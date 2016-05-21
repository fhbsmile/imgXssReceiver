package com.tsystems.si.aviation.img.imgXssReceiver.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsystems.si.aviation.img.imgXssReceiver.bean.RefAirport;
import com.tsystems.si.aviation.img.imgXssReceiver.dao.RefAirportDaoI;
import com.tsystems.si.aviation.img.imgXssReceiver.service.AirportServiceI;


@Service
public class AirportServiceImpl implements AirportServiceI {
	private static final Logger     logger               = LoggerFactory.getLogger(AirportServiceImpl.class);
	@Autowired
    private RefAirportDaoI refAirportDao;
	@Override
	public void saveOrUpdate(RefAirport refAirport) {
		// TODO Auto-generated method stub
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("rapCode", refAirport.getRapCode());
		String sql = "from RefAirport f where f.rapCode = :rapCode";
		List<RefAirport> refAirports =refAirportDao.find(sql, params);
		
		if(refAirports.isEmpty()){
			logger.info("Can not find the airport to update, insert new airport......");
			refAirportDao.save(refAirport);
			logger.info("Insert new airport success......");
		}else{
			logger.info("Find the airport to update, update old airport......");
			RefAirport refAirportQ = refAirports.get(0);
			logger.info("Old airport :{}",refAirportQ.toString());
			logger.info("New airport :{}",refAirport.toString());
			String[] a = {"rapCode"};
	        BeanUtils.copyProperties(refAirport, refAirportQ,a);
	        refAirportDao.update(refAirportQ);
	        logger.info("Update old airport success......");
		}
	}

	@Override
	public void delete(RefAirport refAirport) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("rapCode", refAirport.getRapIata3lc());
		String sql = "from RefAirport f where f.rapCode = :rapCode";
		List<RefAirport> refAirports =refAirportDao.find(sql, params);

		if(refAirports.isEmpty()){
			logger.error("Can not find the airport to delete!!!! Ingnore delete message!");
		}else{
			logger.info("Airline is deleting........");
          for(RefAirport refAirportQ: refAirports){
        	  refAirportDao.delete(refAirportQ);
          }
          logger.info("Airline delete success........");
		}
	}

}
