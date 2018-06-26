package com.github.josebr1.controllers;

import java.io.IOException;

import org.xml.sax.SAXException;

import com.github.josebr1.models.EdifactConvert;

public class EdifactController {

	public String toXMLConvert(String path) {
		EdifactConvert convert = new EdifactConvert();
		try {
			convert.toXML(path);
			return "Conversion successful!";
		} catch (IOException | SAXException e) {
			System.err.println(e.getMessage());
			return "Message: Edifact format invalid";
		}
	}
}
