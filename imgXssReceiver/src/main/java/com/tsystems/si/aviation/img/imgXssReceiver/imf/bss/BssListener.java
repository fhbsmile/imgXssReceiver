package com.tsystems.si.aviation.img.imgXssReceiver.imf.bss;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tsystems.aviation.imf.client.commons.ImfServiceType;
import com.tsystems.aviation.imf.client.exception.ImfClientConnectionException;
import com.tsystems.aviation.imf.client.exception.ImfClientInvalidServiceTypeException;
import com.tsystems.aviation.imf.client.exception.ImfClientSsException;
import com.tsystems.aviation.imf.client.heartbeat.ImfHeartbeatManager;
import com.tsystems.aviation.imf.client.message.ImfMessageListener;
import com.tsystems.aviation.imf.client.subsystem.ImfSsAutoClient;
import com.tsystems.si.aviation.img.imgXssReceiver.bean.RefAirline;
import com.tsystems.si.aviation.img.imgXssReceiver.bean.RefAirport;
import com.tsystems.si.aviation.img.imgXssReceiver.service.AirlineServiceI;
import com.tsystems.si.aviation.img.imgXssReceiver.service.AirportServiceI;
@Repository
public class BssListener extends ImfMessageListener implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1024859583374222895L;
	private static final Logger     logger               = LoggerFactory.getLogger(BssListener.class);
	/**
	 * 
	 */

	@Autowired
    private AirlineServiceI airlineService;
	@Autowired
    private AirportServiceI airportService;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		ImfSsAutoClient bssClient =null;
		try {
			logger.info("bssClient is initing..............");
			bssClient = ImfSsAutoClient.getImfSsAutoClient(ImfServiceType.BSS1, this);
			logger.info("bssClient finish init ..............");
		} catch (ImfClientConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("bssClient init failed!!", e);
			System.exit(0);
		} catch (ImfClientInvalidServiceTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("bssClient init failed!!", e);
			System.exit(0);
		}
		
		try {
			logger.info("bssClient is subscribing..............");
			bssClient.subscribe();
			logger.info("bssClient is subscribe successed..............");
		} catch (ImfClientConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("bssClient subscribe failed!!", e);
			System.exit(0);
		} catch (ImfClientSsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("bssClient subscribe failed!!", e);
			System.exit(0);
		}
	}

	@Override
	public void handleMessage(String msg) {
		// TODO Auto-generated method stub
		    String sequenceID = StringUtils.substringBetween(msg, "<MessageSequenceID>", "</MessageSequenceID>");
		 if (ImfHeartbeatManager.isHbMessage(msg)) {
             if (StringUtils.contains(msg, "<ServiceStatus>Online</ServiceStatus>")) {
                 logger.info("BSS HeartBeat Message,MessageSequenceID:{},Status:Online ",sequenceID);
                 
             } else {
            	 logger.info("BSS HeartBeat Message,MessageSequenceID:{},Status:Offline ",sequenceID);
             }
             
         } else {
             if (StringUtils.contains(msg, "<ServiceType>FSS2</ServiceType>") && StringUtils.contains(msg, "<SubscriptionStatus>Start</SubscriptionStatus>")) {
            	 logger.info("BSS2 Start   received,MessageSequenceID:{} >>>>>>>>>>>>>>>>",sequenceID);
            	 logger.info(msg);
             } else if (StringUtils.contains(msg, "<ServiceType>FSS2</ServiceType>") && StringUtils.contains(msg, "<SubscriptionStatus>End</SubscriptionStatus>")) {
            	 logger.info("BSS2 End     received,MessageSequenceID:{} >>>>>>>>>>>>>>>>",sequenceID);
            	 logger.info(msg);
             } 
             
             if(StringUtils.contains(msg, "<MessageType>BasicData</MessageType>")){

            	 String serviceType = StringUtils.substringBetween(msg, "<ServiceType>", "</ServiceType>");
            	 String operationMode = StringUtils.substringBetween(msg, "<OperationMode>", "</OperationMode>");
            	 String basicDataCategory = StringUtils.substringBetween(msg, "<BasicDataCategory>", "</BasicDataCategory>");
            	 logger.info(msg);
            	 logger.info("{} Message received, BasicDataCategory:{}, OperationMode:{}, MessageSequenceID:{} >>>>>>>>>>>>>>>>",new Object[]{serviceType,basicDataCategory,operationMode,sequenceID});
            
            	 logger.info("Begin to handle messsage........");
            	 if(basicDataCategory.equals("Airport")){
                	 RefAirport airport = AirportMessage.parseBssAirport(msg);
                	 if(operationMode.equals("DEL")){
                		 airportService.delete(airport);
                	 }else{
                		 airportService.saveOrUpdate(airport);
                	 }
            	 }else if(basicDataCategory.equals("Airline")){
                	 RefAirline airline = AirlineMessage.parseBssAirline(msg);
                	 if(operationMode.equals("DEL")){
                		 airlineService.delete(airline);
                	 }else{
                		 if(airline.getRal2lc()!=null && airline.getRal2lc()!=""){
                			 airlineService.saveOrUpdate(airline);
                		 }
                		 
                	 }
            	 }else{
            		 logger.error("Unknow BasicDataCategory!! Message ignored!");
            	 }
            	 logger.info("End to handle messsage........");
             }


         }
	}
	
	

}
