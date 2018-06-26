package com.github.josebr1.models;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.apache.ws.commons.serialize.XMLWriter;
import org.apache.ws.commons.serialize.XMLWriterImpl;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import com.appliedmodels.edifact.parser.EdifactParser;

public class EdifactConvert {

	public void toXML(String path) throws FileNotFoundException, IOException, SAXException {
		Writer out = new OutputStreamWriter(System.out);
		try {
			XMLReader edifactParser = new EdifactParser();
			XMLWriter handler = new XMLWriterImpl();
			handler.setWriter(out);
			edifactParser.setContentHandler(handler);
			edifactParser.parse(new InputSource(new FileReader(path)));
		} finally {
			out.flush();
			out.close();
		}
	}
	
}
