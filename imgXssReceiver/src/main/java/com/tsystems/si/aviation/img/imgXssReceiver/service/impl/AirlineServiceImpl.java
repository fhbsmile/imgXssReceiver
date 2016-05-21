package com.tsystems.si.aviation.img.imgXssReceiver.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsystems.si.aviation.img.imgXssReceiver.bean.RefAirline;
import com.tsystems.si.aviation.img.imgXssReceiver.dao.RefAirlineDaoI;
import com.tsystems.si.aviation.img.imgXssReceiver.service.AirlineServiceI;


@Service
public class AirlineServiceImpl implements AirlineServiceI {
	private static final Logger     logger               = LoggerFactory.getLogger(AirlineServiceImpl.class);
	@Autowired
    private RefAirlineDaoI refAirlineDao;
	@Override
	public void saveOrUpdate(RefAirline refAirline) {
		// TODO Auto-generated method stub
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ral2lc", refAirline.getRal2lc());
		params.put("ral3lc", refAirline.getRal3lc());
		String sql = "from RefAirline f where f.ral2lc = :ral2lc and f.ral3lc = :ral3lc";
		List<RefAirline> refAirlines =refAirlineDao.find(sql, params);
		
		if(refAirlines.isEmpty()){
			logger.info("Can not find the airline to update, insert new airline......");
			refAirlineDao.save(refAirline);
			logger.info("Insert new airline success......");
		}else{
			logger.info("Find the airline to update, update old airline......");
			RefAirline refAirlineQ = refAirlines.get(0);
			logger.info("Old airline :{}",refAirlineQ.toString());
			logger.info("New airline :{}",refAirline.toString());
			String[] a = {"id"};
	        BeanUtils.copyProperties(refAirline, refAirlineQ,a);
	        refAirlineDao.update(refAirlineQ);
	        logger.info("Update old airline success......");
		}
	}

	@Override
	public void delete(RefAirline refAirline) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ral2lc", refAirline.getRal2lc());
		params.put("ral3lc", refAirline.getRal3lc());
		String sql = "from RefAirline f where f.ral2lc = :ral2lc and f.ral3lc = :ral3lc";
		List<RefAirline> refAirlines =refAirlineDao.find(sql, params);

		if(refAirlines.isEmpty()){
			logger.error("Can not find the airline to delete!!!! Ingnore delete message!");
		}else{
			logger.info("Airline is deleting........");
          for(RefAirline refAirlineQ: refAirlines){
        	  refAirlineDao.delete(refAirlineQ);
          }
          logger.info("Airline delete success........");
		}
	}

}
