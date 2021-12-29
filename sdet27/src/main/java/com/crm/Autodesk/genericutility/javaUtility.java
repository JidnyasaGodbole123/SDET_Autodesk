
package com.crm.Autodesk.genericutility;

import java.util.Date;
import java.util.Random;

import javax.lang.model.element.NestingKind;

/**
 * @author DELL
 *
 */
public class javaUtility {
	/**
	 * its use to generate 
	 * @return
	 */
	public int getRanDomNumber() {
		Random random = new Random();
		int intRandom = random.nextInt(10000);
		return intRandom;
	}
	/**
	 * used to get system date & time in IST format
	 * @return
	 */
	public String getSystemDateAndTime() {
		Date date = new Date();
		return date.toString();
		
	}
	/**
	 * used to get system date in YYYY-MM-DD format
	 * @return
	 */
	public String getSystemDateWithFormate() {
		Date date =new Date();
		String dateAndTime=date.toString();
		
		String YYYY = dateAndTime.split("")[5];
		String DD =dateAndTime.split("")[2];
		int MM =date.getMonth()+1;
		
		String finalFormate = YYYY +"_"+MM+"_"+DD;
		return finalFormate;
	
	}
		
	}


