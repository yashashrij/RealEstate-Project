package com.clearcode.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
	Properties p = new Properties() ;
	public Properties loadProperty(String file) {
		FileInputStream propFile = null;
		try {
			propFile = new FileInputStream(file);
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			try {
				propFile = new FileInputStream("src/test/resources/"+file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			p.load(propFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("File Not Found");
		}
		return p;
	}
}
