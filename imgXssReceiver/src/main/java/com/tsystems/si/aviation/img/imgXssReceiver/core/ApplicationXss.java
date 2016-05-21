package com.tsystems.si.aviation.img.imgXssReceiver.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tsystems.si.aviation.img.imgXssReceiver.imf.bss.BssListener;
import com.tsystems.si.aviation.img.imgXssReceiver.imf.fss.FssListener;

public class ApplicationXss {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
		FssListener fssListener= context.getBean(FssListener.class);
		BssListener bssListener= context.getBean(BssListener.class);
		
		Thread fss = new Thread(fssListener);
		Thread bss = new Thread(bssListener);
		
		fss.start();
		
		bss.start();
		
	}

}
