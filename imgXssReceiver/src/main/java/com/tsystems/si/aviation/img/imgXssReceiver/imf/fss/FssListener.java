package com.tsystems.si.aviation.img.imgXssReceiver.imf.fss;

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
import com.tsystems.si.aviation.img.imgXssReceiver.bean.Flightinfo;
import com.tsystems.si.aviation.img.imgXssReceiver.service.FlightServiceI;

@Repository
public class FssListener extends ImfMessageListener implements Runnable {

	private static final Logger     logger               = LoggerFactory.getLogger(FssListener.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 7329418963029413655L;
	@Autowired
    private FlightServiceI flightinfoService;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		ImfSsAutoClient fssClient =null;
		try {
			logger.info("fssClient is initing..............");
			fssClient = ImfSsAutoClient.getImfSsAutoClient(ImfServiceType.FSS1, this);
			logger.info("fssClient finish init ..............");
		} catch (ImfClientConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("fssClient init failed!!", e);
			System.exit(0);
		} catch (ImfClientInvalidServiceTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("fssClient init failed!!", e);
			System.exit(0);
		}
		
		try {
			logger.info("fssClient is subscribing..............");
			fssClient.subscribe();
			logger.info("fssClient is subscribe successed..............");
		} catch (ImfClientConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("fssClient subscribe failed!!", e);
			System.exit(0);
		} catch (ImfClientSsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("fssClient subscribe failed!!", e);
			System.exit(0);
		}
	}

	@Override
	public void handleMessage(String msg) {
		// TODO Auto-generated method stub
		    String sequenceID = StringUtils.substringBetween(msg, "<MessageSequenceID>", "</MessageSequenceID>");
		 if (ImfHeartbeatManager.isHbMessage(msg)) {
             if (StringUtils.contains(msg, "<ServiceStatus>Online</ServiceStatus>")) {
                 logger.info("FSS HeartBeat Message, MessageSequenceID:{}, Status:Online ",sequenceID);
                 
             } else {
            	 logger.info("FSS HeartBeat Message, MessageSequenceID:{}, Status:Offline ",sequenceID);
             }
             
         } else {
             if (StringUtils.contains(msg, "<ServiceType>FSS2</ServiceType>") && StringUtils.contains(msg, "<SubscriptionStatus>Start</SubscriptionStatus>")) {
            	 logger.info("FSS2 Start   received,MessageSequenceID:{} >>>>>>>>>>>>>>>>",sequenceID);
            	 logger.info(msg);
             } else if (StringUtils.contains(msg, "<ServiceType>FSS2</ServiceType>") && StringUtils.contains(msg, "<SubscriptionStatus>End</SubscriptionStatus>")) {
            	 logger.info("FSS2 End     received,MessageSequenceID:{} >>>>>>>>>>>>>>>>",sequenceID);
            	 logger.info(msg);
             } 
             
             if(StringUtils.contains(msg, "<MessageType>FlightData</MessageType>")){

            	 String serviceType = StringUtils.substringBetween(msg, "<ServiceType>", "</ServiceType>");
            	 String operationMode = StringUtils.substringBetween(msg, "<OperationMode>", "</OperationMode>");
            	 logger.info(msg);
            	 logger.info("{} Message received, OperationMode:{}, MessageSequenceID:{} >>>>>>>>>>>>>>>>",new Object[]{serviceType,operationMode,sequenceID});
            	
            	 logger.info("Begin to handle messsage........");
            	 Flightinfo flight = FlightMessage.parseFssFlight(msg);
            	 if(operationMode.equals("DEL")){
            		 flightinfoService.delete(flight);
            	 }else{
            		 flightinfoService.saveOrUpdate(flight);
            	 }
            	 logger.info("End to handle messsage........");
             }


         }
	}
	
	

}
