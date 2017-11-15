package com.lucascorp.traking.server.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FunctionsUtils {
	
	public static Properties getProp() throws IOException {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream("./../core/properties/lucascorp-traking-server-LO.properties");
		props.load(file);
		return props;
	}

	public static String  getPropertiesByKey(String key) throws IOException {
		Properties prop = getProp();
		return prop.getProperty(key);
	}

}
