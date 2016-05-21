package com.tsystems.si.aviation.img.imgXssReceiver.imf.bss;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tsystems.si.aviation.img.imgXssReceiver.bean.RefAirport;

public class AirportMessage {
private static final Logger     logger               = LoggerFactory.getLogger(AirportMessage.class);
	private static Document doc = null; 

	private static Element root = null; 
	RefAirport airport = new RefAirport();
	
	public static RefAirport parseBssAirport(String airportXml){
		RefAirport airport = new RefAirport();
		try { 
			doc = DocumentHelper.parseText(airportXml); 
			root = doc.getRootElement(); 
			} catch (DocumentException e) { 
				logger.error(">>>>>>>>>>>>>>xml parse error!!!", e);
			e.printStackTrace(); 
			return null;
			} 
		
		Node BasicDataID = root.selectSingleNode("//BasicDataID"); 
		Node AirportIATACode = root.selectSingleNode("//AirportIATACode");
		Node AirportICAOCode = root.selectSingleNode("//AirportICAOCode");
		Node AirportCity = root.selectSingleNode("//AirportCity");
		Node AirportDistance = root.selectSingleNode("//AirportDistance");
		airport.setRapCode(BasicDataID.getText());
		airport.setRapIata3lc(AirportIATACode.getText());
		airport.setRapIcao4lc(AirportICAOCode.getText());
		airport.setRapCity(AirportCity.getText());
		airport.setRapFlytime(AirportDistance.getText());
		logger.info("Airport xml parsed success! {}", airport.toString());
		return airport;
		
	}
}
