/**
 * 
 */
package com.crm.Autodesk.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * @author DELL
 *
 */
public class FileUtility {
	
/**
 *it is used to read the data from commonData.properties File based on key which you pass as an
 argument
 * @param key
 * @return
 * @throws Throwable 
 */
	public String getPropertyKeyValue(String key) throws Throwable {
    FileInputStream fis = new FileInputStream("./data/commonData.properties");
     Properties pobj =new Properties();
     pobj.load(fis);
     String value = pobj.getProperty(key);
     return value;
	}
}


