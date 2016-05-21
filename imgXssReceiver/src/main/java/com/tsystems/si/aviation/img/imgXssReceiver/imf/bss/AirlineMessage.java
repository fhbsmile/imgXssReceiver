package com.tsystems.si.aviation.img.imgXssReceiver.imf.bss;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tsystems.si.aviation.img.imgXssReceiver.bean.RefAirline;
import com.tsystems.si.aviation.img.imgXssReceiver.bean.RefAirport;

public class AirlineMessage {
private static final Logger     logger               = LoggerFactory.getLogger(AirlineMessage.class);
	private static Document doc = null; 

	private static Element root = null; 
	RefAirline airline = new RefAirline();
	
	public static RefAirline parseBssAirline(String airlineXml){
		RefAirline airline = new RefAirline();
		try { 
			doc = DocumentHelper.parseText(airlineXml); 
			root = doc.getRootElement(); 
			} catch (DocumentException e) { 
				logger.error(">>>>>>>>>>>>>>xml parse error!!!", e);
			e.printStackTrace(); 
			return null;
			} 
		
		Node BasicDataID = root.selectSingleNode("//BasicDataID"); 
		Node AirlineICAOCode = root.selectSingleNode("//AirlineICAOCode");
		Node AirlineDescription = root.selectSingleNode("//AirlineDescription");
		airline.setRal2lc(BasicDataID.getText());
		airline.setRal3lc(AirlineICAOCode.getText());
		airline.setRalName(AirlineDescription.getText());
        
		logger.info("Airline xml parsed success! {}", airline.toString());
		return airline;
		
	}
}
