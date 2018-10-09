package com.anthem.hrsoap.service.impl;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.anthem.hrsoap.config.SOAPConnector;
import com.anthem.hrsoap.schemas.dilbert.DailyDilbert;
import com.anthem.hrsoap.schemas.dilbert.DailyDilbertResponse;
import com.anthem.hrsoap.service.DailyDilbertService;

@Service(value="dailyDilbertService")
public class DailyDilbertServiceImpl implements DailyDilbertService {

	@Autowired
	SOAPConnector soapConnector;
	
	public void getDailyDilbert() {
		
		System.out.println("......Daily Dilbert Example......");
		
		DailyDilbert aDailyDilbert = new DailyDilbert();
		
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(new Date());
		XMLGregorianCalendar date2 = null;
		
		try {
			date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 aDailyDilbert.setADate(date2);
		
		 DailyDilbertResponse response =(DailyDilbertResponse)soapConnector.callWebService("http://www.gcomputer.net/webservices/dilbert.asmx", aDailyDilbert, new SoapActionCallback("http://gcomputer.net/webservices/DailyDilbert"));
		 System.out.println("---------Result---------"+response.getDailyDilbertResult());
	}

}
