package com.github.josebr1.models;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XMLFormatter {
	public String format(String xml) {
		return xmlConvert(xml, "2");
	}
	
	private static String xmlConvert(String xml, String indent) {
		Source sourceXML = new StreamSource(new StringReader(xml));
		StringWriter stringWriter = new StringWriter();
		
		try {
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", indent);
			transformer.transform(sourceXML, new StreamResult(stringWriter));
			
			return stringWriter.toString().trim();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
