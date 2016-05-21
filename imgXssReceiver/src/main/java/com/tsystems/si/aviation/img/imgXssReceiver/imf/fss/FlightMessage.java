package com.tsystems.si.aviation.img.imgXssReceiver.imf.fss;

import java.util.Date;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tsystems.si.aviation.img.imgXssReceiver.bean.Flightinfo;
import com.tsystems.si.aviation.img.imgXssReceiver.bean.RefAirport;
import com.tsystems.si.aviation.img.imgXssReceiver.utils.DateHandle;

public class FlightMessage {
private static final Logger     logger               = LoggerFactory.getLogger(FlightMessage.class);
	private static Document doc = null; 

	private static Element root = null; 
	RefAirport airport = new RefAirport();
	
	public static Flightinfo parseFssFlight(String flightXml){
		Flightinfo flight = new Flightinfo();
		try { 
			doc = DocumentHelper.parseText(flightXml); 
			root = doc.getRootElement(); 
			} catch (DocumentException e) { 
				logger.error(">>>>>>>>>>>>>>xml parse error!!!", e);
			e.printStackTrace(); 
			return null;
			} 
		
		Node MessageSequenceID = root.selectSingleNode("//MessageSequenceID"); 
		
		Node FlightScheduledDate = root.selectSingleNode("//FlightKey/FlightScheduledDate");
		Date flightScheduledDate = DateHandle.getDateByString_fmtShortDate(FlightScheduledDate.getText());
		flight.setFlightScheduledDate(flightScheduledDate);
		
		Node FlightIdentity = root.selectSingleNode("//FlightKey/FlightIdentity");
		flight.setFlightIdentity(FlightIdentity.getText());
		
		Node FlightDirection = root.selectSingleNode("//FlightKey/FlightDirection");
		flight.setFlightDirection(FlightDirection.getText());
		
		Node FlightScheduledDateTime = root.selectSingleNode("//FlightScheduledDateTime");
		if(FlightScheduledDateTime !=null){
			Date flightScheduledDateTime = DateHandle.getDateByString_fmtStandardDate(FlightScheduledDateTime.getText());
			flight.setFlightScheduledDateTime(flightScheduledDateTime);
		}
		
		Node Registration = root.selectSingleNode("//Registration");
		if(Registration !=null){
			flight.setRegistration(Registration.getText());
		}
		
		Node CallSign = root.selectSingleNode("//CallSign");
		if(CallSign !=null){
			flight.setCallSign(CallSign.getText());
		}
		
		Node IATAOriginAirport = root.selectSingleNode("//IATAOriginAirport");
		if(IATAOriginAirport !=null){
			flight.setIataoriginAirport(IATAOriginAirport.getText());
		}
		
		
		Node IATAPreviousAirport = root.selectSingleNode("//IATAPreviousAirport");
		if(IATAPreviousAirport !=null){
			flight.setIatapreviousAirport(IATAPreviousAirport.getText());
		}
		
		Node IATANextAirport = root.selectSingleNode("//IATANextAirport");
		if(IATANextAirport !=null){
			flight.setIatanextAirport(IATANextAirport.getText());
		}
		
		Node IATADestinationAirport = root.selectSingleNode("//IATADestinationAirport");
		if(IATADestinationAirport !=null){
			flight.setIatadestinationAirport(IATADestinationAirport.getText());
		}
		
		Node ActualPreviousAirportDepartureDateTime = root.selectSingleNode("//ActualPreviousAirportDepartureDateTime");
		if(ActualPreviousAirportDepartureDateTime !=null){
			flight.setPeratot(ActualPreviousAirportDepartureDateTime.getText());
		}
		
		Node EstimatedLandingDateTime = root.selectSingleNode("//EstimatedLandingDateTime");
		if(EstimatedLandingDateTime !=null){
			flight.setEstimatedLandingDateTime(EstimatedLandingDateTime.getText());
		}
		
		Node ActualLandingDateTime = root.selectSingleNode("//ActualLandingDateTime");
		if(ActualLandingDateTime !=null){
			flight.setAldt(ActualLandingDateTime.getText());
		}
		
		@SuppressWarnings("unchecked")
		List<Node> MasterOrSlaveFlight = root.selectNodes("//MasterOrSlaveFlight/FlightIdentity");
		if(MasterOrSlaveFlight!=null){
			StringBuffer codeShare = new StringBuffer();
	
			for(int i=0 ;i<MasterOrSlaveFlight.size();i++){
				Node n = MasterOrSlaveFlight.get(i);
				String text = n.getText();
				if(text!=null && text.trim()!=""){
					codeShare.append(",").append(text);
				}
			}
			flight.setShareFlightIdentity(codeShare.toString().replaceFirst(",", ""));
		}
		
		Node ActualOnBlockDateTime = root.selectSingleNode("//ActualOnBlockDateTime");
		if(ActualOnBlockDateTime !=null){
			flight.setAibt(ActualOnBlockDateTime.getText());
		}
		
		Node EstimatedTakeOffDateTime = root.selectSingleNode("//EstimatedTakeOffDateTime");
		if(EstimatedTakeOffDateTime !=null){
			flight.setEstimatedTakeOffDateTime(EstimatedTakeOffDateTime.getText());
		}
		
		Node ActualOffBlockDateTime  = root.selectSingleNode("//ActualOffBlockDateTime");
		if(ActualOffBlockDateTime !=null){
			flight.setAobt(ActualOffBlockDateTime.getText());
		}
		
		Node ActualTakeOffDateTime   = root.selectSingleNode("//ActualTakeOffDateTime");
		if(ActualTakeOffDateTime !=null){
			flight.setAtot(ActualTakeOffDateTime.getText());
		}
		
         flight.setCreatetime(DateHandle.getStringByDate_fmtStandardDate(new Date()));
         flight.setUpdatetime(DateHandle.getStringByDate_fmtStandardDate(new Date()));
		logger.info("Flight xml parsed success! {}", flight.toString());
		return flight;
		
	}
}
