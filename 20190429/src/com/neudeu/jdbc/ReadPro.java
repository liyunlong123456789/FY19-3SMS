package com.neudeu.jdbc;

import java.io.IOException;
import java.util.Properties;

public class ReadPro {
	public static void main(String[] args) {
		Properties properties = new Properties();
		try {
			properties.load(ReadPro.class.getResourceAsStream("/settings.properties"));
			String object = (String)properties.get("url");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
