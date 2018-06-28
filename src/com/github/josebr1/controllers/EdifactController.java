package com.github.josebr1.controllers;

import java.io.File;
import java.io.IOException;

import org.xml.sax.SAXException;

import com.github.josebr1.models.EdifactConvert;

public class EdifactController {

	public String xml(File[] path) {
		EdifactConvert convert = new EdifactConvert();
		try {
			convert.toXML(path);
			return "Conversion successful!";
		} catch (IOException | SAXException | InterruptedException e) {
			System.err.println(e.getMessage());
			return "Message: Edifact format invalid";
		}
	}
}
