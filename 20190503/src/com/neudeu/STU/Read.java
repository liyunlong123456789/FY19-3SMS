package com.neudeu.STU;

import java.io.IOException;
import java.util.Properties;

import com.neudeu.STU.Read;

public class Read {
	public static void main(String[] args) {
		Properties properties = new Properties();
		try {
			properties.load(Read.class.getResourceAsStream("/settings.properties"));
			String object = (String)properties.get("url");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
